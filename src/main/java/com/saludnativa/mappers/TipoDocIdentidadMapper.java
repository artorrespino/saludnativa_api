package com.saludnativa.mappers;

import com.saludnativa.dtos.TipoDocIdentidadCreateDTO;
import com.saludnativa.dtos.TipoDocIdentidadDTO;
import com.saludnativa.dtos.TipoDocIdentidadUpdateDTO;
import com.saludnativa.model.TipoDocIdentidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocIdentidadMapper {

    TipoDocIdentidadMapper INSTANCIA = Mappers.getMapper(TipoDocIdentidadMapper.class);

    TipoDocIdentidadDTO tipoDocIdentidadATipoDocIdentidadDTO(TipoDocIdentidad tipoDocIdentidad);
    TipoDocIdentidad tipoDocIdentidadDTOATipoDocIdentidad(TipoDocIdentidadDTO tipoDocIdentidadDTO);
    TipoDocIdentidad tipoDocIdentidadCreateDTOATipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO);
    TipoDocIdentidad tipoDocIdentidadUpdateDTOTipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO);

    List<TipoDocIdentidadDTO> listaTipoDocIdentidadAListaTipoDocIdentidadDTO (List<TipoDocIdentidad> listarTipoDocIdentidad);
}
