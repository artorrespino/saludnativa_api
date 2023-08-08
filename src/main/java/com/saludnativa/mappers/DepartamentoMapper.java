package com.saludnativa.mappers;

import com.saludnativa.dtos.DepartamentoDTO;
import com.saludnativa.model.Departamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartamentoMapper {

    DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);

    DepartamentoDTO departmentToDepartmentDTO(Departamento department);

    List<DepartamentoDTO> departmentListToDepartmentDTOList(List<Departamento> listarDepartamentos);
}
