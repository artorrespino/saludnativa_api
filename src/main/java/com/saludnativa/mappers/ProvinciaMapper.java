package com.saludnativa.mappers;

import com.saludnativa.dtos.ProvinciaDTO;
import com.saludnativa.model.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface ProvinciaMapper {

    ProvinciaMapper INSTANCE = Mappers.getMapper(ProvinciaMapper.class);

    ProvinciaDTO provinceToProvinceDTO(Provincia provincia);

    List<ProvinciaDTO> provinceListToProvinceDTOList(List<Provincia> listarProvincias);
}
