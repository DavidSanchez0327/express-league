package co.com.bancolombia.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String cedula;
    private String nombre;
    private String alias;
    private Integer edad;
    private Integer telefono;
    private String correo;
    private Integer numeroEmergencia;

}
