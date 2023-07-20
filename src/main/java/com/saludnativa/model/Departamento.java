package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {

    @Id
    private String idUbigeo;
    private String nombreUbigeo;
    private String codigoUbigeo;
    private String etiquetaUbigeo;
    private String buscadorUbigeo;
    private String numeroHijosUbigeo;
    private String nivelUbigeo;
    private String idPadreUbigeo;

    @OneToMany(mappedBy = "departamento")
    private List<Provincia> provincias;

}
