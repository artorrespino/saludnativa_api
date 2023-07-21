package com.saludnativa.service;

import com.saludnativa.dtos.CarritoComprasCreateDTO;
import com.saludnativa.dtos.CarritoComprasDTO;
import com.saludnativa.dtos.CarritoComprasUpdateDTO;
import com.saludnativa.mappers.CarritoComprasMapper;
import com.saludnativa.model.CarritoCompras;
import com.saludnativa.repository.CarritoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarritoComprasServiceImpl implements CarritoComprasService {

    @Autowired
    private CarritoComprasRepository carritoComprasRepository;

    @Override
    public List<CarritoComprasDTO> listarCarritoCompras() {
        return CarritoComprasMapper.INSTANCIA.listaCarritoComprasAListaCarritoComprasDTO(carritoComprasRepository.findAll());
    }

    @Override
    public CarritoComprasDTO obtenerCarritoComprasPorID(long id) {
        return carritoComprasRepository.findById(id)
                .map(CarritoComprasMapper.INSTANCIA::carritoComprasACarritoComprasDTO)
                .orElse(null);
    }

    @Override
    public CarritoComprasDTO registrarCarritoCompras(CarritoComprasCreateDTO carritoComprasCreateDTO) {
        CarritoCompras carritoCompras = CarritoComprasMapper.INSTANCIA.carritoComprasCreateDTOACarritoCompras(carritoComprasCreateDTO);

        // Obtener la fecha actual y establecerla en el campo fec_registro_carrito
        carritoCompras.setFec_registro_carrito(LocalDate.now());

        CarritoCompras carritoComprasGuardado = carritoComprasRepository.save(carritoCompras);
        return CarritoComprasMapper.INSTANCIA.carritoComprasACarritoComprasDTO(carritoComprasGuardado);
    }

    @Override
    public CarritoComprasDTO actualizarCarritoCompras(CarritoComprasUpdateDTO carritoComprasUpdateDTO) {
        CarritoCompras carritoCompras = CarritoComprasMapper.INSTANCIA.carritoComprasUpdateDTOACarritoCompras(carritoComprasUpdateDTO);

        // Obtener la fecha actual y establecerla en el campo fec_registro_carrito
        carritoCompras.setFec_registro_carrito(LocalDate.now());

        CarritoCompras carritoComprasActualizado = carritoComprasRepository.save(carritoCompras);
        return CarritoComprasMapper.INSTANCIA.carritoComprasACarritoComprasDTO(carritoComprasActualizado);
    }

    @Override
    public String eliminarCarritoCompras(long id) {
        Optional<CarritoCompras> carritoComprasOptional = carritoComprasRepository.findById(id);
        carritoComprasOptional.ifPresentOrElse(
                carritoCompras -> carritoComprasRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró el carrito de compras con id = " + id);
                }
        );
        return "Carrito de compras eliminado";
    }
}
