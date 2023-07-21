package com.saludnativa.mappers;

import com.saludnativa.dtos.DetalleCarritoComprasCreateDTO;
import com.saludnativa.dtos.DetalleCarritoComprasDTO;
import com.saludnativa.model.DetalleCarritoCompras;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetalleCarritoComprasMapper {

    DetalleCarritoComprasMapper INSTANCIA = Mappers.getMapper(DetalleCarritoComprasMapper.class);

    List<DetalleCarritoComprasDTO> listaDetalleCarritoAListaDetalleCarritoDTO (List<DetalleCarritoCompras> listaDetalleCarrito);

    DetalleCarritoCompras detalleCarritoCreateDTOADetalleCarrito(DetalleCarritoComprasCreateDTO detalleCarritoComprasCreateDTO);
}
