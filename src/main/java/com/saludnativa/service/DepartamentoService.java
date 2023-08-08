package com.saludnativa.service;

import com.saludnativa.dtos.DepartamentoDTO;

import java.util.List;

public interface DepartamentoService {

    List<DepartamentoDTO> getDepartmentsByProvince(String provinciaId);
}
