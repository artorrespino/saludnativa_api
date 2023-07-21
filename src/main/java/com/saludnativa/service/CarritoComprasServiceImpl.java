package com.saludnativa.service;

import com.saludnativa.dtos.*;
import com.saludnativa.mappers.CarritoComprasMapper;
import com.saludnativa.mappers.DetalleCarritoComprasMapper;
import com.saludnativa.model.CarritoCompras;
import com.saludnativa.model.DetalleCarritoCompras;
import com.saludnativa.repository.CarritoComprasRepository;
import com.saludnativa.repository.DetalleCarritoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarritoComprasServiceImpl implements CarritoComprasService {

    @Autowired
    private CarritoComprasRepository carritoComprasRepository;

    @Autowired
    private DetalleCarritoComprasRepository detalleCarritoComprasRepository;

    @Override
    public List<CarritoComprasDTO> listarCarritoCompras() {
        List<CarritoComprasDTO> lista = CarritoComprasMapper.INSTANCIA.listaCarritoComprasAListaCarritoComprasDTO(carritoComprasRepository.findAll());
        for (CarritoComprasDTO carritoComprasDTO : lista){
            List<DetalleCarritoComprasDTO> detalleCarritoComprasDTO = DetalleCarritoComprasMapper.INSTANCIA.listaDetalleCarritoAListaDetalleCarritoDTO(detalleCarritoComprasRepository.findByCarritoCompras_Id_Carrito(carritoComprasDTO.getId_carrito())
            );
            carritoComprasDTO.setDetalleCarritoDTO(detalleCarritoComprasDTO);
        }

        return lista;
    }


    @Override
    public CarritoComprasDTO obtenerCarritoComprasPorID(long id) {
        Optional<CarritoCompras> carrito = carritoComprasRepository.findById(id);
        CarritoComprasDTO carritoComprasDTO = null;
        if(carrito.isPresent()){
            carritoComprasDTO = CarritoComprasMapper.INSTANCIA.carritoComprasACarritoComprasDTO(carrito.get());
            carritoComprasDTO.setDetalleCarritoDTO(
                    DetalleCarritoComprasMapper.INSTANCIA.listaDetalleCarritoAListaDetalleCarritoDTO(detalleCarritoComprasRepository.findByCarritoCompras_Id_Carrito(carrito.get().getId_carrito()))
            );
        }
        return carritoComprasDTO;
    }

    @Override
    @Transactional
    public CarritoComprasDTO registrarCarritoCompras(CarritoComprasCreateDTO carritoComprasCreateDTO) {

        CarritoCompras carrito=CarritoComprasMapper.INSTANCIA.carritoComprasCreateDTOACarritoCompras(carritoComprasCreateDTO);
        CarritoCompras respuestaEntity=carritoComprasRepository.save(carrito);

        for (DetalleCarritoComprasCreateDTO detCarritoCreateDTO : carritoComprasCreateDTO.getDetalleCarritoCreateDTO()){
            DetalleCarritoCompras detalleCarrito = DetalleCarritoComprasMapper.INSTANCIA.detalleCarritoCreateDTOADetalleCarrito(detCarritoCreateDTO);
            detalleCarrito.setCarritoCompras(respuestaEntity);
            detalleCarritoComprasRepository.save(detalleCarrito);
        }

        CarritoComprasDTO respuestaDTO= CarritoComprasMapper.INSTANCIA.carritoComprasACarritoComprasDTO(carritoComprasRepository.getById(respuestaEntity.getId_carrito()));
        respuestaDTO.setDetalleCarritoDTO(
                DetalleCarritoComprasMapper.INSTANCIA.listaDetalleCarritoAListaDetalleCarritoDTO(detalleCarritoComprasRepository.findByCarritoCompras_Id_Carrito(respuestaEntity.getId_carrito()))
        );
        return respuestaDTO;
    }

}
