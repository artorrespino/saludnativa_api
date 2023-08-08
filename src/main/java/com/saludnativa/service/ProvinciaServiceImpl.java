package com.saludnativa.service;

import com.saludnativa.dtos.DepartamentoDTO;
import com.saludnativa.dtos.ProvinciaDTO;
import com.saludnativa.mappers.DepartamentoMapper;
import com.saludnativa.mappers.ProvinciaMapper;
import com.saludnativa.model.Departamento;
import com.saludnativa.model.Provincia;
import com.saludnativa.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<ProvinciaDTO> getAllProvincias() {
        return ProvinciaMapper.INSTANCE.provinceListToProvinceDTOList(provinciaRepository.findAll());
    }

}
