package com.saludnativa.dtos;

import com.saludnativa.model.Departamento;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProvinciaDTO {

    private String id;
    private String name;
    private Departamento departamento;
}
