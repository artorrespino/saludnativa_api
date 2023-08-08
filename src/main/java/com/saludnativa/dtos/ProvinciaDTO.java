package com.saludnativa.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProvinciaDTO {

    private String id;
    private String name;
    private DepartamentoDTO departmento;
}
