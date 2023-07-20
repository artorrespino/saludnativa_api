package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")//@JoinColumn(name = "email", referencedColumnName = "email")  Columna para la relación con Usuario
    private Usuario usuario;

    @Column(name="fecha_nacimiento", nullable = false)
    private LocalDate fec_nacimiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_doc_identidad")
    private TipoDocIdentidad tipoDocIdentidad;

    @Column(length = 50, nullable = false )
    private String num_doc_identidad;

    @Column(length = 150, nullable = false )
    private String direccion;
/*
    @ManyToOne
    @JoinColumn(name = "distrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "provincia")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "departamento")
    private Departamento departamento;

 */

    @ManyToOne
    @JoinColumn(name = "id_estado_usuario")
    private Estado estado;



}
