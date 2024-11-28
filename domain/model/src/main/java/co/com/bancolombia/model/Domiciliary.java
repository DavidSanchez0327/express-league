package co.com.bancolombia.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Domiciliary {

    private String cedula;
    private String placa;
    private String referenciaMoto;
    private int numero;
}
