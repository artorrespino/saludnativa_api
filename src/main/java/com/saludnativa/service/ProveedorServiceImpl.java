package com.saludnativa.service;

import com.saludnativa.dtos.ProveedorCreateDTO;
import com.saludnativa.dtos.ProveedorDTO;
import com.saludnativa.dtos.ProveedorUpdateDTO;
import com.saludnativa.mappers.ProveedorMapper;
import com.saludnativa.model.Estado;
import com.saludnativa.model.Proveedor;
import com.saludnativa.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorDTO> listarProveedores() {
        return ProveedorMapper.INSTANCIA.listaProveedorAListaProveedorDTO(proveedorRepository.findAll());
    }

    @Override
    public ProveedorDTO obtenerProveedorPorID(long id) {
        return proveedorRepository.findById(id)
                .map(ProveedorMapper.INSTANCIA::proveedorAProveedorDTO)
                .orElse(null);
    }

    @Override
    public ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO) {
        Proveedor proveedor = ProveedorMapper.INSTANCIA.proveedorCreateDTOAProveedor(proveedorCreateDTO);
        Proveedor proveedorGuardado = proveedorRepository.save(proveedor);
        return ProveedorMapper.INSTANCIA.proveedorAProveedorDTO(proveedorGuardado);
    }

    @Override
    public ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO) {
        Proveedor proveedor = ProveedorMapper.INSTANCIA.proveedorUpdateDTOAProveedor(proveedorUpdateDTO);
        Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
        return ProveedorMapper.INSTANCIA.proveedorAProveedorDTO(proveedorActualizado);
    }

    @Override
    public String eliminarProveedor(long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            Estado estadoEliminado = new Estado();
            estadoEliminado.setId_estado(2L); // Depende de la tb_estado_usuario ID del estado "eliminado" es 3
            proveedor.setEstado(estadoEliminado);
            proveedorRepository.save(proveedor);
            return "Proveedor eliminado correctamente";
        } else {
            throw new NoSuchElementException("No se encontró el proveedor con ID = " + id);
        }
    }
}
