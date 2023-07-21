package com.saludnativa.service;

import com.saludnativa.dtos.CarritoComprasCreateDTO;
import com.saludnativa.dtos.CarritoComprasDTO;
import com.saludnativa.dtos.CarritoComprasUpdateDTO;

import java.util.List;

public interface CarritoComprasService {

    List<CarritoComprasDTO> listarCarritoCompras();
    CarritoComprasDTO obtenerCarritoComprasPorID(long id);
    CarritoComprasDTO registrarCarritoCompras(CarritoComprasCreateDTO carritoComprasCreateDTO);
    CarritoComprasDTO actualizarCarritoCompras(CarritoComprasUpdateDTO carritoComprasUpdateDTO);
    String eliminarCarritoCompras(long id);
}
