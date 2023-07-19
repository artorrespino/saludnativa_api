package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_estado_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado_usuario;

    @Column(length = 20, nullable = false )
    private String estado_usuario;
}
