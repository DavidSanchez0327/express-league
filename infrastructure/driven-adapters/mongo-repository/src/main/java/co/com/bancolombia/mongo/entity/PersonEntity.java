package co.com.bancolombia.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Person")
@Data
public class PersonEntity {

    @Id
    private String cedula;
    private String nombre;
    private String alias;
    private Integer edad;
    private Integer telefono;
    private String correo;
    private Integer numeroEmergencia;
}
