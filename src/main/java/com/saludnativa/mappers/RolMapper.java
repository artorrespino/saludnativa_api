package com.saludnativa.mappers;

import com.saludnativa.dtos.RolCreateDTO;
import com.saludnativa.dtos.RolDTO;
import com.saludnativa.dtos.RolUpdateDTO;
import com.saludnativa.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RolMapper {

        RolMapper INSTANCIA = Mappers.getMapper(RolMapper.class);

        RolDTO rolARolDTO(Rol rol);
        Rol rolDTOARol(RolDTO rolDTO);
        Rol rolCreateDTOARol(RolCreateDTO rolCreateDTO);
        Rol rolUpdateDTOARol(RolUpdateDTO rolUpdateDTO);

        List<RolDTO> listaRolAlistaRolDTO (List<Rol> listaRol);

}
