package com.saludnativa.dtos;

import com.saludnativa.model.CategoriaProducto;
import com.saludnativa.model.Proveedor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

    private Long id_producto  ;
    private String nombre_producto ;
    private String imagen_producto  ;
    private String descripcion_producto  ;
    private String precio_unitario_producto  ;
    private String stock_producto  ;
    private CategoriaProducto categoriaProducto ;
    private Proveedor proveedor  ;
}
