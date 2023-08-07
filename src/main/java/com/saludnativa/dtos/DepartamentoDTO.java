package com.saludnativa.dtos;

import com.saludnativa.model.Provincia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DepartamentoDTO {

    private String idUbigeo;
    private String nombreUbigeo;
    private String codigoUbigeo;
    private String etiquetaUbigeo;
    private String buscadorUbigeo;
    private String numeroHijosUbigeo;
    private String nivelUbigeo;
    private String idPadreUbigeo;
    private List<Provincia> provincias;
}
