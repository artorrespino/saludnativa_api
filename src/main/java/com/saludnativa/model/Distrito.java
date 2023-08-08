package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ubigeo_peru_districts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departamento departamento;
}
