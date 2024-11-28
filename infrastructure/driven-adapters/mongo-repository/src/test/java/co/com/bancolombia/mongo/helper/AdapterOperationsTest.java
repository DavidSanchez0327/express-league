package co.com.bancolombia.mongo.helper;
/*
import co.com.bancolombia.model.Person;
import co.com.bancolombia.mongo.PersonDBRepository;
import co.com.bancolombia.mongo.PersonEntity;
import co.com.bancolombia.mongo.PersonRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AdapterOperationsTest {

    @Mock
    private PersonDBRepository repository;

    @Mock
    private ObjectMapper objectMapper;

    private PersonRepositoryAdapter adapter;

    private PersonEntity entity;
    private Flux<Object> entities;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new PersonRepositoryAdapter(repository, objectMapper);

        entity = PersonEntity.builder().build();
        entities = Flux.just(entity);
    }

    @Test
    void testSave() {
        when(repository.save(entity)).thenReturn(Mono.just(PersonEntity.builder().build()));

        StepVerifier.create(adapter.save(entity))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testSaveAll() {
        when(repository.saveAll(any(Flux.class))).thenReturn(entities);

        StepVerifier.create(adapter.saveAll(entities))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testFindById() {
        when(repository.findById("key")).thenReturn(Mono.just(entity));

        StepVerifier.create(adapter.findById("key"))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testFindByExample() {
        when(repository.findAll(any(Example.class))).thenReturn(entities);

        StepVerifier.create(adapter.findByExample(entity))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(entities);

        StepVerifier.create(adapter.findAll())
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testDeleteById() {
        when(repository.deleteById("key")).thenReturn(Mono.empty());

        StepVerifier.create(adapter.deleteById("key"))
                .verifyComplete();
    }
}
*/