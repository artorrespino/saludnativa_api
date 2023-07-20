package com.saludnativa.dtos;

import com.saludnativa.model.Estado;
import com.saludnativa.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id_usuario;
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String celular;
    private String email;
    private String contrasenia;
    private Integer intentos_login;
    private Rol rol;
    private Estado estado;
}
