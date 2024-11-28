package co.com.bancolombia.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("domiciliary")
@Data
public class DomiciliaryEntity {

    @Id
    private String cedula;
    private String placa;
    private String referenciaMoto;
    private int numero;

}
