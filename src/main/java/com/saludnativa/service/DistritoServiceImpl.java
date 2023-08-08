package com.saludnativa.service;

import com.saludnativa.dtos.DistritoDTO;
import com.saludnativa.mappers.DistritoMapper;
import com.saludnativa.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoDTO> getDistrictsByDepartmentAndProvince(String departamentoId, String provinciaId) {
        return DistritoMapper.INSTANCE.districtListToDistrictDTOList(
                distritoRepository.findDistritosByDepartamentoIdAndProvinciaId(departamentoId, provinciaId)
        );
    }
}
