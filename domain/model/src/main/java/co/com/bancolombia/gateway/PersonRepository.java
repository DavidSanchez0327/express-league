package co.com.bancolombia.gateway;

import co.com.bancolombia.model.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonRepository {

    Mono<Person> save(Person person);
    Mono<Person> getPersonById(String id);
    Mono<List<Person>> findAllPersons();
    Mono<Person> update(Person person);
    Mono<Person> delete(String id);
}
