package co.com.bancolombia.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonDBRepository extends ReactiveMongoRepository<PersonEntity, String>, ReactiveQueryByExampleExecutor<PersonEntity>, ReactiveCrudRepository<PersonEntity, String> {
}
