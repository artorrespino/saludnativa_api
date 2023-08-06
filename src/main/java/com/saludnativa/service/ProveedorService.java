package com.saludnativa.service;

import com.saludnativa.dtos.ProveedorCreateDTO;
import com.saludnativa.dtos.ProveedorDTO;
import com.saludnativa.dtos.ProveedorUpdateDTO;

import java.util.List;

public interface ProveedorService {

    List<ProveedorDTO> listarProveedores();
    List<ProveedorDTO> listarProveedoresActivos();
    ProveedorDTO obtenerProveedorPorID(long id);
    ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO);
    ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO);
    ProveedorDTO eliminarProveedor(long id);

}
