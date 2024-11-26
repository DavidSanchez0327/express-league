package co.com.bancolombia.gateway;

import co.com.bancolombia.model.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);
    Person findById(String id);
    List<Person> findAll();
    Person update(Person person);
    Boolean delete(String id);
}
