package co.com.bancolombia.usecase;

import co.com.bancolombia.gateway.PersonRepository;
import co.com.bancolombia.model.Person;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepository personRepository;

    public Mono<Person> getPersonById(String cedula) {
        return personRepository.getPersonById(cedula);
    }


    public Mono<List<Person>> getPersons() {
        return personRepository.findAllPersons();
    }

    public Mono<Person> createPerson(Person person) {
        return personRepository.save(person);
    }

    public Mono<Person> updatePerson(Person person) {
        return personRepository.update(person);
    }

    public Mono<Person> deletePerson(String cedula) {
        return personRepository.delete(cedula);
    }

}
