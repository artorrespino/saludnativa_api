package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_proveedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor ;

    @Column(length = 50, nullable = false )
    private String nombre_proveedor  ;

    @Column(length = 100, nullable = false )
    private String contacto_proveedor  ;

    @Column(length = 100, nullable = false )
    private String email_proveedor ;

    @Column(length = 30, nullable = false )
    private String celular_proveedor  ;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;



}
