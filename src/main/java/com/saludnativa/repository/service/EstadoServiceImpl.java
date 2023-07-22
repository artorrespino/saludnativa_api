package com.saludnativa.repository.service;

import com.saludnativa.dtos.EstadoCreateDTO;
import com.saludnativa.dtos.EstadoDTO;
import com.saludnativa.dtos.EstadoUpdateDTO;
import com.saludnativa.mappers.EstadoMapper;
import com.saludnativa.model.Estado;
import com.saludnativa.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository EstadoRepository;

    @Override
    public List<EstadoDTO> listarEstado() {
        return EstadoMapper.INSTANCIA.listaEstadoAListaEstadoDTO( EstadoRepository.findAll());
    }

    @Override
    public EstadoDTO obtenerEstadoPorID(long id) {
        return EstadoRepository.findById(id)
                .map(EstadoMapper.INSTANCIA::EstadoAEstadoDTO)
                .orElse(null);
    }

    @Override
    public EstadoDTO registrarEstado(EstadoCreateDTO EstadoCreateDTO) {
        Estado Estado=EstadoMapper.INSTANCIA.EstadoCreateDTOAEstado(EstadoCreateDTO);
        Estado respuestaEntity=EstadoRepository.save(Estado);
        EstadoDTO respuestaDTO = EstadoMapper.INSTANCIA.EstadoAEstadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EstadoDTO actualizarEstado(EstadoUpdateDTO EstadoUpdateDTO) {
        Estado Estado=EstadoMapper.INSTANCIA.EstadoUptadeDTOAEstado(EstadoUpdateDTO);
        Estado respuestaEntity=EstadoRepository.save(Estado);
        EstadoDTO respuestaDTO = EstadoMapper.INSTANCIA.EstadoAEstadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarEstado(long id) {
        Optional<Estado> EstadoOptional= EstadoRepository.findById(id);
        EstadoOptional.ifPresentOrElse(// Si el Optional contiene un estado, se ejecutará la primera lambda con el Estado como argumento, que simplemente eliminará el estado de usuario mediante
                Estado -> EstadoRepository.deleteById(id),
                ()->{
                    throw new NoSuchElementException("No se encontró el estado con id = " + id);// Si el Optional está vacío, se ejecutará la segunda lambda, que lanzará una excepción NoSuchElementException indicando que no se encontró el estado de usuario con el ID especificado.
                }
        );
        return "Registro de estado eliminado";
    }
}
