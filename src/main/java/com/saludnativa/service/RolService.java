package com.saludnativa.service;

import com.saludnativa.dtos.RolCreateDTO;
import com.saludnativa.dtos.RolDTO;
import com.saludnativa.dtos.RolUpdateDTO;

import java.util.List;

public interface RolService {

    List<RolDTO> listarRol();
    RolDTO obtenerRolPorID(long id);
    RolDTO registrarRol(RolCreateDTO rolCreateDTO);
    RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO);
    String eliminarRol(long id);
}
