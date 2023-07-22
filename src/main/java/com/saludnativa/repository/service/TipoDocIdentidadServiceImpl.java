package com.saludnativa.repository.service;

import com.saludnativa.dtos.TipoDocIdentidadCreateDTO;
import com.saludnativa.dtos.TipoDocIdentidadDTO;
import com.saludnativa.dtos.TipoDocIdentidadUpdateDTO;
import com.saludnativa.mappers.TipoDocIdentidadMapper;
import com.saludnativa.model.TipoDocIdentidad;
import com.saludnativa.repository.TipoDocIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoDocIdentidadServiceImpl implements TipoDocIdentidadService {

    @Autowired
    private TipoDocIdentidadRepository tipoDocIdentidadRepository;

    @Override
    public List<TipoDocIdentidadDTO> listarTipoDocIdentidad() {
        return TipoDocIdentidadMapper.INSTANCIA.listaTipoDocIdentidadAListaTipoDocIdentidadDTO(tipoDocIdentidadRepository.findAll());
    }

    @Override
    public TipoDocIdentidadDTO obtenerTipoDocIdentidadPorID(long id) {
        return tipoDocIdentidadRepository.findById(id)
                .map(TipoDocIdentidadMapper.INSTANCIA::tipoDocIdentidadATipoDocIdentidadDTO)
                .orElse(null);
    }

    @Override
    public TipoDocIdentidadDTO registrarTipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO) {
        TipoDocIdentidad tipoDocIdentidad = TipoDocIdentidadMapper.INSTANCIA.tipoDocIdentidadCreateDTOATipoDocIdentidad(tipoDocIdentidadCreateDTO);
        TipoDocIdentidad respuestaEntity = tipoDocIdentidadRepository.save(tipoDocIdentidad);
        TipoDocIdentidadDTO respuestaDTO = TipoDocIdentidadMapper.INSTANCIA.tipoDocIdentidadATipoDocIdentidadDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public TipoDocIdentidadDTO actualizarTipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO) {
        TipoDocIdentidad tipoDocIdentidad = TipoDocIdentidadMapper.INSTANCIA.tipoDocIdentidadUpdateDTOTipoDocIdentidad(tipoDocIdentidadUpdateDTO);
        TipoDocIdentidad respuestaEntity = tipoDocIdentidadRepository.save(tipoDocIdentidad);
        TipoDocIdentidadDTO respuestaDTO = TipoDocIdentidadMapper.INSTANCIA.tipoDocIdentidadATipoDocIdentidadDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarTipoDocIdentidad(long id) {
        Optional<TipoDocIdentidad> tipoDocIdentidadOptional = tipoDocIdentidadRepository.findById(id);
        tipoDocIdentidadOptional.ifPresentOrElse(
                tipoDocIdentidad -> tipoDocIdentidadRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró el tipo de documento con id = " + id);
                }
        );
        return "Registro de tipo de documento eliminado";
    }
}
