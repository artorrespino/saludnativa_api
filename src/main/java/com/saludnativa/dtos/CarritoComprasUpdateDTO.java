package com.saludnativa.dtos;

import com.saludnativa.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarritoComprasUpdateDTO {

    private Long id_carrito;
    private Cliente cliente;
    private LocalDate fec_registro_carrito;
}
