package com.saludnativa.mappers;

import com.saludnativa.dtos.DistritoDTO;
import com.saludnativa.model.Distrito;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistritoMapper {

    DistritoMapper INSTANCE = Mappers.getMapper(DistritoMapper.class);

    DistritoDTO districtToDistrictDTO(Distrito district);

    List<DistritoDTO> districtListToDistrictDTOList(List<Distrito> listarDistritos);
}
