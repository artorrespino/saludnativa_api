package com.saludnativa.dtos;

import com.saludnativa.model.Provincia;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DistritoDTO {

    private String id;
    private String name;
    private ProvinciaDTO provincia;
    private DepartamentoDTO departamento;
}
