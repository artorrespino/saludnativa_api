package com.saludnativa.mappers;

import com.saludnativa.dtos.ProductoCreateDTO;
import com.saludnativa.dtos.ProductoDTO;
import com.saludnativa.dtos.ProductoUpdateDTO;
import com.saludnativa.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCIA = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);
    Producto productoDTOAProducto(ProductoDTO productoDTO);
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);

    List<ProductoDTO> listaProductoAListaProductoDTO(List<Producto> listaProducto);
}
