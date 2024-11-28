package co.com.bancolombia.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomiciliaryDto {

    private String cedula;
    private String placa;
    private String referenciaMoto;
    private int numero;
}
