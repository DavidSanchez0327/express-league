package co.com.bancolombia.usecase;

import co.com.bancolombia.gateway.DomiciliaryRepository;
import co.com.bancolombia.gateway.PersonRepository;
import co.com.bancolombia.model.Domiciliary;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class DomiciliaryUseCase {

    private final DomiciliaryRepository domiciliaryRepository;
    private final PersonRepository personRepository;


    public Mono<Domiciliary> create(Domiciliary domiciliary) {
        return personRepository.getPersonById(domiciliary.getCedula())
                .flatMap(person -> domiciliaryRepository.save(domiciliary));
    }

    public Mono<Domiciliary> update(Domiciliary domiciliary) {
        return domiciliaryRepository.update(domiciliary);
    }

    public  Mono<Domiciliary> findByCedula(String cedula) {
        return domiciliaryRepository.getDomiciliaryById(cedula);
    }

    public Mono<List<Domiciliary>> findAll(){
        return domiciliaryRepository.findAllDomiciliaries();
    }

    public Mono<Domiciliary> delete(String cedula) {
        return domiciliaryRepository.delete(cedula);
    }
}
