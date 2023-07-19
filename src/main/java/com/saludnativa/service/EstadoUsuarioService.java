package com.saludnativa.service;


import com.saludnativa.dtos.EstadoUsuarioCreateDTO;
import com.saludnativa.dtos.EstadoUsuarioDTO;
import com.saludnativa.dtos.EstadoUsuarioUpdateDTO;

import java.util.List;

public interface EstadoUsuarioService {

    List<EstadoUsuarioDTO> listarEstadoUsurio();
    EstadoUsuarioDTO obtenerEstadoUsuarioPorID(long id);
    EstadoUsuarioDTO registrarEstadoUsuario(EstadoUsuarioCreateDTO estadoUsuarioCreateDTO);
    EstadoUsuarioDTO actualizarEstadoUsuario(EstadoUsuarioUpdateDTO estadoUsuarioUpdateDTO);
    String eliminarEstadoUsuario(long id);
}
