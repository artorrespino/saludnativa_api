package com.saludnativa.service;

import com.saludnativa.dtos.UsuarioCreateDTO;
import com.saludnativa.dtos.UsuarioDTO;
import com.saludnativa.dtos.UsuarioUpdateDTO;
import com.saludnativa.mappers.UsuarioMapper;
import com.saludnativa.model.Estado;
import com.saludnativa.model.Usuario;
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

    @Override
    public List<UsuarioDTO> listarUsuario() {
        return UsuarioMapper.INSTANCIA.listaUsuarioAListaUsuarioDTO(usuarioRepository.findAll());
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
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.INSTANCIA.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Estado estadoEliminado = new Estado();
            estadoEliminado.setId_estado(5L); // Depende de la tb_estado_usuario ID del estado "eliminado" es 3
            usuario.setEstado(estadoEliminado);
            usuarioRepository.save(usuario);
            return "Usuario eliminado correctamente";
        } else {
            throw new NoSuchElementException("No se encontró el usuario con ID = " + id);
        }
    }
}
