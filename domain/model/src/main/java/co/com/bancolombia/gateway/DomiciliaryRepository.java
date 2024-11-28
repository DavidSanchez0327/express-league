package co.com.bancolombia.gateway;

import co.com.bancolombia.model.Domiciliary;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DomiciliaryRepository {

    Mono<Domiciliary> save(Domiciliary domiciliary);

    Mono<Domiciliary> getDomiciliaryById(String id);

    Mono<List<Domiciliary>> findAllDomiciliaries();

    Mono<Domiciliary> update(Domiciliary domiciliary);

    Mono<Domiciliary> delete(String id);
}
