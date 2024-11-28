package co.com.bancolombia.mongo;

import co.com.bancolombia.gateway.PersonRepository;
import co.com.bancolombia.model.Person;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class PersonRepositoryAdapter extends AdapterOperations<Person, PersonEntity, String, PersonDBRepository>
        implements PersonRepository {

    private final PersonDBRepository personDBRepository;

    public PersonRepositoryAdapter(PersonDBRepository repository, ObjectMapper mapper, PersonDBRepository personDBRepository) {

        super(repository, mapper, d -> mapper.map(d, Person.class));
        this.personDBRepository = personDBRepository;
    }

    @Override
    public Mono<Person> save(Person person) {
        return personDBRepository.save(mapper.map(person, PersonEntity.class))
                .switchIfEmpty(Mono.error(new RuntimeException("No se pudo guardar la persona")))
                .map(personEntity -> mapper.map(personEntity, Person.class));
    }

    @Override
    public Mono<Person> getPersonById(String id) {
        return personDBRepository.findById(id)
                .map(person -> mapper.map(person, Person.class));
    }

    @Override
    public Mono<List<Person>> findAllPersons() {
        return personDBRepository.findAll()
                .switchIfEmpty(Mono.error(new RuntimeException("No existen personas guardadas")))
                .map(personEntity -> mapper.map(personEntity, Person.class))
                .collectList();
    }

    @Override
    public Mono<Person> update(Person person) {
        return personDBRepository.findById(person.getCedula())
                .switchIfEmpty(Mono.error(new RuntimeException("No existe la persona buscada")))
                .map(personEntity -> updatePerson(person, personEntity))
                .flatMap(personEntity -> personDBRepository.save(personEntity)
                        .map(personEntity1 -> mapper.map(personEntity1, Person.class)));
    }

    @Override
    public Mono<Person> delete(String id) {
        return personDBRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("No existe la persona buscada")))
                .flatMap(personEntity -> personDBRepository.deleteById(personEntity.getCedula())
                        .then(Mono.fromCallable(() -> mapper.map(personEntity, Person.class))));
    }

    private static PersonEntity updatePerson(Person person, PersonEntity personEntity) {
        personEntity.setNombre(person.getNombre());
        personEntity.setAlias(person.getAlias());
        personEntity.setCorreo(person.getCorreo());
        personEntity.setTelefono(person.getTelefono());
        personEntity.setNumeroEmergencia(person.getNumeroEmergencia());
        return personEntity;
    }
}
