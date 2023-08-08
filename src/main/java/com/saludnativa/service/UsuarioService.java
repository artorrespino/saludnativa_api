package com.saludnativa.service;

import com.saludnativa.dtos.UsuarioCreateDTO;
import com.saludnativa.dtos.UsuarioDTO;
import com.saludnativa.dtos.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuario();
    List<UsuarioDTO> listarUsuariosActivos();
    UsuarioDTO obtenerUsuarioPorID(long id);
    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    UsuarioDTO eliminarUsuario(long id);
}
