package com.saludnativa.service;

import com.saludnativa.dtos.DepartamentoDTO;
import com.saludnativa.dtos.ProvinciaDTO;

import java.util.List;

public interface ProvinciaService {

    List<ProvinciaDTO> getProvinceByDepartments(String departamentoId);
}
