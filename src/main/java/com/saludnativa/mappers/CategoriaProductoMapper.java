package com.saludnativa.mappers;

import com.saludnativa.dtos.CategoriaProductoCreateDTO;
import com.saludnativa.dtos.CategoriaProductoDTO;
import com.saludnativa.dtos.CategoriaProductoUpdateDTO;
import com.saludnativa.model.CategoriaProducto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaProductoMapper {

    CategoriaProductoMapper INSTANCIA = Mappers.getMapper(CategoriaProductoMapper.class);

    CategoriaProductoDTO categoriaProductoACategoriaProductoDTO(CategoriaProducto categoriaProducto);
    CategoriaProducto categoriaProductoDTOACategoriaProducto(CategoriaProductoDTO categoriaProductoDTO);
    CategoriaProducto categoriaProductoCreateDTOACategoriaProducto(CategoriaProductoCreateDTO categoriaProductoCreateDTO);
    CategoriaProducto categoriaProductoUpdateDTOACategoriaProducto(CategoriaProductoUpdateDTO categoriaProductoUpdateDTO);

    List<CategoriaProductoDTO> listaCategoriaProductoAListaCategoriaProductoDTO(List<CategoriaProducto> listaCategoriaProducto);
}
