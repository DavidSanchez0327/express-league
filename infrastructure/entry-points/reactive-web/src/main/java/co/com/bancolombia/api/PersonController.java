package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.PersonDto;
import co.com.bancolombia.model.Person;
import co.com.bancolombia.usecase.PersonUseCase;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private PersonUseCase personUseCase;

    @GetMapping("/{id}")
    public Mono<PersonDto> getPersonById(@PathVariable String id) {
        return personUseCase.getPersonById(id)
                .map(PersonController::buildPersonDto);
    }


    @GetMapping("/list")
    public Mono<List<PersonDto>> getPersons() {
        return personUseCase.getPersons()
                .map(persons -> persons
                        .stream()
                        .map(PersonController::buildPersonDto)
                        .toList());
    }

    @PostMapping
    public Mono<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        return personUseCase.createPerson(buildPerson(personDto))
                .map(PersonController::buildPersonDto);
    }


    @PutMapping
    public Mono<PersonDto> updatePerson(@RequestBody PersonDto personDto) {
        return personUseCase.updatePerson(buildPerson(personDto))
                .map(PersonController::buildPersonDto);
    }

    @DeleteMapping("/{id}")
    public Mono<PersonDto> deletePerson(@PathVariable String id) {
        return null;
    }

    private static PersonDto buildPersonDto(Person person) {
        return PersonDto.builder()
                .cedula(person.getCedula())
                .nombre(person.getNombre())
                .alias(person.getAlias())
                .edad(person.getEdad())
                .correo(person.getCorreo())
                .telefono(person.getTelefono())
                .numeroEmergencia(person.getNumeroEmergencia())
                .build();
    }

    private static Person buildPerson(PersonDto personDto) {
        return Person.builder()
                .cedula(personDto.getCedula())
                .edad(personDto.getEdad())
                .nombre(personDto.getNombre())
                .alias(personDto.getAlias())
                .correo(personDto.getCorreo())
                .edad(personDto.getEdad())
                .telefono(personDto.getTelefono())
                .numeroEmergencia(personDto.getNumeroEmergencia())
                .build();
    }
}

