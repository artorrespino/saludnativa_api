package com.saludnativa.service;

import com.saludnativa.dtos.UsuarioCreateDTO;
import com.saludnativa.dtos.UsuarioDTO;
import com.saludnativa.dtos.UsuarioUpdateDTO;
import com.saludnativa.mappers.UsuarioMapper;
import com.saludnativa.model.Estado;
import com.saludnativa.model.Usuario;
import com.saludnativa.repository.EstadoRepository;
import com.saludnativa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServiceImple implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<UsuarioDTO> listarUsuario() {
        return UsuarioMapper.INSTANCIA.listaUsuarioAListaUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public List<UsuarioDTO> listarUsuariosActivos() {
        List<Usuario> usuariosActivos = usuarioRepository.findByEstadoIdEstado(1L);
        return UsuarioMapper.INSTANCIA.listaUsuarioAListaUsuarioDTO(usuariosActivos);
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorID(long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper.INSTANCIA::usuarioAUsuarioDTO)
                .orElse(null);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = UsuarioMapper.INSTANCIA.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        Estado estadoActivo = estadoRepository.findById(1L).orElse(null);// Obtener el estado activo desde la base de datos por su ID
        usuario.setEstado(estadoActivo);// Asignar el estado activo al usuario antes de guardarlo
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO((usuarioGuardado));
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.INSTANCIA.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Estado estadoEliminado = new Estado();
            estadoEliminado.setId_estado(2L); // Depende de la tb_estado_usuario ID del estado "eliminado" es 2
            usuario.setEstado(estadoEliminado);
            usuarioRepository.save(usuario);
            UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(usuario);
            return usuarioDTO;
        } else {
            throw new NoSuchElementException("No se encontró el usuario con ID = " + id);
        }
    }
}
