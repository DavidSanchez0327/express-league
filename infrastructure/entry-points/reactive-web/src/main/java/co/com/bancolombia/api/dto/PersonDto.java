package co.com.bancolombia.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {

    private String cedula;
    private String nombre;
    private Integer edad;
    private String alias;
    private Integer telefono;
    private String correo;
    private Integer numeroEmergencia;
}
