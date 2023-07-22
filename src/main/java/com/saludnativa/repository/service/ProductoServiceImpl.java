package com.saludnativa.repository.service;

import com.saludnativa.dtos.ProductoCreateDTO;
import com.saludnativa.dtos.ProductoDTO;
import com.saludnativa.dtos.ProductoUpdateDTO;
import com.saludnativa.mappers.ProductoMapper;
import com.saludnativa.model.Producto;
import com.saludnativa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return ProductoMapper.INSTANCIA.listaProductoAListaProductoDTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper.INSTANCIA::productoAProductoDTO)
                .orElse(null);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO) {
        Producto producto = ProductoMapper.INSTANCIA.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntity = productoRepository.save(producto);
        ProductoDTO respuestaDTO = ProductoMapper.INSTANCIA.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto = ProductoMapper.INSTANCIA.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntity = productoRepository.save(producto);
        ProductoDTO respuestaDTO = ProductoMapper.INSTANCIA.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarProducto(long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        productoOptional.ifPresentOrElse(
                producto -> productoRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró el producto con id = " + id);
                }
        );
        return "Registro de producto eliminado";
    }
}
