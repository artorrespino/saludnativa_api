package com.saludnativa.service;

import com.saludnativa.dtos.ProductoCreateDTO;
import com.saludnativa.dtos.ProductoDTO;
import com.saludnativa.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProductoPorID(long id);
    ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);
    String eliminarProducto(long id);
}
