package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_detalle_carrito_compras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCarritoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_carrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrito")
    private CarritoCompras carritoCompras;

    @OneToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @Column(nullable = false)
    private BigDecimal subTotal;

    @Column(nullable = false)
    private BigDecimal descuentos;

    @Column(nullable = false)
    private BigDecimal total;
}
