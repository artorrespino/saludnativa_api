package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provincia {

    @Id
    private String idUbigeo;
    private String nombreUbigeo;
    private String codigoUbigeo;
    private String etiquetaUbigeo;
    private String buscadorUbigeo;
    private String numeroHijosUbigeo;
    private String nivelUbigeo;
    private String idPadreUbigeo;

    @ManyToOne
    private Departamento departamento;

    @OneToMany(mappedBy = "provincia")
    private List<Distrito> distritos;
}
