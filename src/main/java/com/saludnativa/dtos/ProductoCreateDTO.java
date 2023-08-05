package com.saludnativa.dtos;

import com.saludnativa.model.CategoriaProducto;
import com.saludnativa.model.Proveedor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoCreateDTO {

    private String nombre_producto ;
    private String imagen_producto  ;
    private String descripcion_producto  ;
    private BigDecimal precio_unitario_producto  ;
    private Integer stock_producto  ;
    private CategoriaProducto categoriaProducto ;
    private Proveedor proveedor  ;
}
