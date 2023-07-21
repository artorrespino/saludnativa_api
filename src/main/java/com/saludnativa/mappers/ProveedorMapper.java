package com.saludnativa.mappers;

import com.saludnativa.dtos.ProveedorCreateDTO;
import com.saludnativa.dtos.ProveedorDTO;
import com.saludnativa.dtos.ProveedorUpdateDTO;
import com.saludnativa.model.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper INSTANCIA = Mappers.getMapper(ProveedorMapper.class);

    ProveedorDTO proveedorAProveedorDTO(Proveedor proveedor);
    Proveedor proveedorDTOAProveedor(ProveedorDTO proveedorDTO);
    Proveedor proveedorCreateDTOAProveedor(ProveedorCreateDTO proveedorCreateDTO);
    Proveedor proveedorUpdateDTOAProveedor(ProveedorUpdateDTO proveedorUpdateDTO);

    List<ProveedorDTO> listaProveedorAListaProveedorDTO(List<Proveedor> listaProveedor);
}
