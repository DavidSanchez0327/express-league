package co.com.bancolombia.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private String cedula;
    private String nombre;
    private String alias;
    private Integer edad;
    private Integer telefono;
    private String correo;
    private Integer numeroEmergencia;

}
