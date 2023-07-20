package com.saludnativa.mappers;

import com.saludnativa.dtos.EstadoCreateDTO;
import com.saludnativa.dtos.EstadoDTO;
import com.saludnativa.dtos.EstadoUpdateDTO;
import com.saludnativa.model.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoMapper {

    EstadoMapper INSTANCIA = Mappers.getMapper(EstadoMapper.class);

    EstadoDTO EstadoAEstadoDTO(Estado Estado);
    Estado EstadoDTOAEstado(EstadoDTO EstadoDTO);
    Estado EstadoCreateDTOAEstado(EstadoCreateDTO EstadoCreateDTO);
    Estado EstadoUptadeDTOAEstado(EstadoUpdateDTO EstadoUpdateDTO);

    List<EstadoDTO> listaEstadoAListaEstadoDTO (List<Estado> listaEstado);
}
