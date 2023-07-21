package com.saludnativa.dtos;

import com.saludnativa.model.CarritoCompras;
import com.saludnativa.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DetalleCarritoComprasDTO {

    private Long id_detalle_carrito;
    private Producto producto;
    private Long cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private BigDecimal descuentos;
    private BigDecimal total;
}
