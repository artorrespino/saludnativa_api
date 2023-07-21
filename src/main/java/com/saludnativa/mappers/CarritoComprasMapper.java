package com.saludnativa.mappers;

import com.saludnativa.dtos.CarritoComprasCreateDTO;
import com.saludnativa.dtos.CarritoComprasDTO;
import com.saludnativa.dtos.CarritoComprasUpdateDTO;
import com.saludnativa.model.CarritoCompras;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarritoComprasMapper {

    CarritoComprasMapper INSTANCIA = Mappers.getMapper(CarritoComprasMapper.class);

    CarritoComprasDTO carritoComprasACarritoComprasDTO(CarritoCompras carritoCompras);
    CarritoCompras carritoComprasDTOACarritoCompras(CarritoComprasDTO carritoComprasDTO);
    CarritoCompras carritoComprasCreateDTOACarritoCompras(CarritoComprasCreateDTO carritoComprasCreateDTO);
    CarritoCompras carritoComprasUpdateDTOACarritoCompras(CarritoComprasUpdateDTO carritoComprasUpdateDTO);

    List<CarritoComprasDTO> listaCarritoComprasAListaCarritoComprasDTO(List<CarritoCompras> listaCarritoCompras);
}
