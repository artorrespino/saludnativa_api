package com.saludnativa.dtos;

import com.saludnativa.model.Provincia;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DistritoDTO {

    private String idUbigeo;
    private String nombreUbigeo;
    private String codigoUbigeo;
    private String etiquetaUbigeo;
    private String buscadorUbigeo;
    private String numeroHijosUbigeo;
    private String nivelUbigeo;
    private String idPadreUbigeo;
    private Provincia provincia;
}
