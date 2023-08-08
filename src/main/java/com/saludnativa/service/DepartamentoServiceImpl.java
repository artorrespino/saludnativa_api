package com.saludnativa.service;

import com.saludnativa.dtos.DepartamentoDTO;
import com.saludnativa.mappers.DepartamentoMapper;
import com.saludnativa.model.Departamento;
import com.saludnativa.model.Provincia;
import com.saludnativa.repository.DepartamentoRepository;
import com.saludnativa.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<DepartamentoDTO> getDepartmentsByProvince(String provinciaId) {
        Provincia provincia = provinciaRepository.findById(provinciaId).orElse(null);
        if (provincia == null) {
            throw new IllegalArgumentException("Provincia no encontrada con el ID proporcionado: " + provinciaId);
        }

        List<Departamento> departamentos = departamentoRepository.findDepartamentosByProvincia(provincia);
        return DepartamentoMapper.INSTANCE.departmentListToDepartmentDTOList(departamentos);
    }
}
