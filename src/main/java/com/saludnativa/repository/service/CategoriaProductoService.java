package com.saludnativa.repository.service;

import com.saludnativa.dtos.CategoriaProductoCreateDTO;
import com.saludnativa.dtos.CategoriaProductoDTO;
import com.saludnativa.dtos.CategoriaProductoUpdateDTO;

import java.util.List;

public interface CategoriaProductoService {

    List<CategoriaProductoDTO> listarCategoriasProducto();
    CategoriaProductoDTO obtenerCategoriaProductoPorID(long id);
    CategoriaProductoDTO registrarCategoriaProducto(CategoriaProductoCreateDTO categoriaProductoCreateDTO);
    CategoriaProductoDTO actualizarCategoriaProducto(CategoriaProductoUpdateDTO categoriaProductoUpdateDTO);
    String eliminarCategoriaProducto(long id);
}
