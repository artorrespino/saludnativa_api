package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_estado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    @Column(length = 20, nullable = false )
    private String estado;

    @PrePersist
    public void prePersist() {
        // Establecer el valor por defecto para el estado "activo" (1)
        this.id_estado = 1L;
    }
}
