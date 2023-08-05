package com.saludnativa.service;

import com.saludnativa.dtos.TipoDocIdentidadCreateDTO;
import com.saludnativa.dtos.TipoDocIdentidadDTO;
import com.saludnativa.dtos.TipoDocIdentidadUpdateDTO;

import java.util.List;

public interface TipoDocIdentidadService {

    List<TipoDocIdentidadDTO> listarTipoDocIdentidad();
    TipoDocIdentidadDTO obtenerTipoDocIdentidadPorID(long id);
    TipoDocIdentidadDTO registrarTipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO);
    TipoDocIdentidadDTO actualizarTipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO);
    String eliminarTipoDocIdentidad(long id);
}
