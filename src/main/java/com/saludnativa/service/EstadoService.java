package com.saludnativa.service;


import com.saludnativa.dtos.EstadoCreateDTO;
import com.saludnativa.dtos.EstadoDTO;
import com.saludnativa.dtos.EstadoUpdateDTO;

import java.util.List;

public interface EstadoService {

    List<EstadoDTO> listarEstado();
    EstadoDTO obtenerEstadoPorID(long id);
    EstadoDTO registrarEstado(EstadoCreateDTO EstadoCreateDTO);
    EstadoDTO actualizarEstado(EstadoUpdateDTO EstadoUpdateDTO);
    String eliminarEstado(long id);
}
