package com.saludnativa.service;

import com.saludnativa.dtos.EstadoUsuarioCreateDTO;
import com.saludnativa.dtos.EstadoUsuarioDTO;
import com.saludnativa.dtos.EstadoUsuarioUpdateDTO;
import com.saludnativa.mappers.EstadoUsuarioMapper;
import com.saludnativa.model.EstadoUsuario;
import com.saludnativa.repository.EstadoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstadoUsuarioServiceImpl implements EstadoUsuarioService {

    @Autowired
    private EstadoUsuarioRepository estadoUsuarioRepository;

    @Override
    public List<EstadoUsuarioDTO> listarEstadoUsurio() {
        return EstadoUsuarioMapper.INSTANCIA.listaEstadoUsuarioAListaEstadoUsuarioDTO( estadoUsuarioRepository.findAll());
    }

    @Override
    public EstadoUsuarioDTO obtenerEstadoUsuarioPorID(long id) {
        return estadoUsuarioRepository.findById(id)
                .map(EstadoUsuarioMapper.INSTANCIA::estadoUsuarioAEstadoUsuarioDTO)
                .orElse(null);
    }

    @Override
    public EstadoUsuarioDTO registrarEstadoUsuario(EstadoUsuarioCreateDTO estadoUsuarioCreateDTO) {
        EstadoUsuario estadoUsuario=EstadoUsuarioMapper.INSTANCIA.estadoUsuarioCreateDTOAEstadoUsuario(estadoUsuarioCreateDTO);
        EstadoUsuario respuestaEntity=estadoUsuarioRepository.save(estadoUsuario);
        EstadoUsuarioDTO respuestaDTO = EstadoUsuarioMapper.INSTANCIA.estadoUsuarioAEstadoUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EstadoUsuarioDTO actualizarEstadoUsuario(EstadoUsuarioUpdateDTO estadoUsuarioUpdateDTO) {
        EstadoUsuario estadoUsuario=EstadoUsuarioMapper.INSTANCIA.estadoUsuarioUptadeDTOAEstadoUsuario(estadoUsuarioUpdateDTO);
        EstadoUsuario respuestaEntity=estadoUsuarioRepository.save(estadoUsuario);
        EstadoUsuarioDTO respuestaDTO = EstadoUsuarioMapper.INSTANCIA.estadoUsuarioAEstadoUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarEstadoUsuario(long id) {
        Optional<EstadoUsuario> estadoUsuarioOptional= estadoUsuarioRepository.findById(id);
        estadoUsuarioOptional.ifPresentOrElse(// Si el Optional contiene un estado de usuario, se ejecutará la primera lambda con el estadoUsuario como argumento, que simplemente eliminará el estado de usuario mediante
                estadoUsuario -> estadoUsuarioRepository.deleteById(id),
                ()->{
                    throw new NoSuchElementException("No se encontró el estado usuario con id = " + id);// Si el Optional está vacío, se ejecutará la segunda lambda, que lanzará una excepción NoSuchElementException indicando que no se encontró el estado de usuario con el ID especificado.
                }
        );
        return "Registro de usuario eliminado";
    }
}
