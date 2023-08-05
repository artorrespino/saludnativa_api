package com.saludnativa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto  ;

    @Column(length = 100, nullable = false )
    private String nombre_producto ;

    @Column(length = 500)
    private String imagen_producto  ;

    @Column(length = 200, nullable = false )
    private String descripcion_producto  ;

    @Column
    private BigDecimal precio_unitario_producto  ;

    @Column
    private Integer stock_producto  ;

    @ManyToOne
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto ;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor  ;
}
