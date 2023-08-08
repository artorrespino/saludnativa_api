package com.saludnativa.service;

import com.saludnativa.dtos.DistritoDTO;

import java.util.List;

public interface DistritoService {

    List<DistritoDTO> getDistrictsByDepartmentAndProvince(String departamentoId, String provinciaId);
}
