package com.saludnativa.dtos;

import com.saludnativa.model.EstadoUsuario;
import com.saludnativa.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    private Long id_usuario;
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String celular;
    //private String email; //El email no debe actualizarse es único
    private String contrasenia;
    private Integer intentos_login;
    private Rol rol;
    private EstadoUsuario estadoUsuario;
}
