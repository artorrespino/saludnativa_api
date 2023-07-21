package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tb_carrito_compras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name="fecha_registro_carrito", nullable = false)
    private LocalDate fec_registro_carrito;

    @OneToMany(mappedBy = "carritoCompras")
    private List<DetalleCarritoCompras> detalleCarritoCompras;


}
