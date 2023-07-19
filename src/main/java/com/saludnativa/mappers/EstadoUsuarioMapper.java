package com.saludnativa.mappers;

import com.saludnativa.dtos.EstadoUsuarioCreateDTO;
import com.saludnativa.dtos.EstadoUsuarioDTO;
import com.saludnativa.dtos.EstadoUsuarioUpdateDTO;
import com.saludnativa.model.EstadoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoUsuarioMapper {

    EstadoUsuarioMapper INSTANCIA = Mappers.getMapper(EstadoUsuarioMapper.class);

    EstadoUsuarioDTO estadoUsuarioAEstadoUsuarioDTO(EstadoUsuario estadoUsuario);
    EstadoUsuario estadoUsuarioDTOAEstadoUsuario(EstadoUsuarioDTO estadoUsuarioDTO);
    EstadoUsuario estadoUsuarioCreateDTOAEstadoUsuario(EstadoUsuarioCreateDTO estadoUsuarioCreateDTO);
    EstadoUsuario estadoUsuarioUptadeDTOAEstadoUsuario(EstadoUsuarioUpdateDTO estadoUsuarioUpdateDTO);

    List<EstadoUsuarioDTO> listaEstadoUsuarioAListaEstadoUsuarioDTO (List<EstadoUsuario> listaEstadoUsuario);
}
