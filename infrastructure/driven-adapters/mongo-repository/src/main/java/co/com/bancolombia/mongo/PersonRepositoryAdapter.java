package co.com.bancolombia.mongo;

import co.com.bancolombia.model.Person;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryAdapter extends AdapterOperations<Person, PersonEntity, String, PersonDBRepository>
// implements ModelRepository from domain
{

    public PersonRepositoryAdapter(PersonDBRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Person.class));
    }
}
