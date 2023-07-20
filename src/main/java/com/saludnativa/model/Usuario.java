package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 50, nullable = false)
    private String ap_paterno;

    @Column(length = 50, nullable = false)
    private String ap_materno;

    @Column(length = 20, nullable = false)
    private String celular;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String contrasenia;

    @Column
    private Integer intentos_login;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_estado_usuario")
    private Estado estado;
}
