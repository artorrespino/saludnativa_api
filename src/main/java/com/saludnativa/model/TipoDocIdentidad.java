package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_tipo_doc_identidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocIdentidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_doc_identidad;

    @Column(length = 50, nullable = false )
    private String tipo_doc_identidad;
}
