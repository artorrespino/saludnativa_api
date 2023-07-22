package com.saludnativa.repository.service;

import com.saludnativa.dtos.CarritoComprasCreateDTO;
import com.saludnativa.dtos.CarritoComprasDTO;

import java.util.List;

public interface CarritoComprasService {

    List<CarritoComprasDTO> listarCarritoCompras();

    CarritoComprasDTO obtenerCarritoComprasPorID(long id);

    CarritoComprasDTO registrarCarritoCompras(CarritoComprasCreateDTO carritoComprasCreateDTO);

}
