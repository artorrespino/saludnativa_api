package com.saludnativa.dtos;

import com.saludnativa.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CarritoComprasDTO {

    private Long id_carrito;
    private Cliente cliente;
    private LocalDate fec_registro_carrito;
    private List<DetalleCarritoComprasDTO> detalleCarritoDTO;
}
