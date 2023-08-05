package com.saludnativa.service;

import com.saludnativa.dtos.CategoriaProductoCreateDTO;
import com.saludnativa.dtos.CategoriaProductoDTO;
import com.saludnativa.dtos.CategoriaProductoUpdateDTO;
import com.saludnativa.mappers.CategoriaProductoMapper;
import com.saludnativa.model.CategoriaProducto;
import com.saludnativa.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<CategoriaProductoDTO> listarCategoriasProducto() {
        return CategoriaProductoMapper.INSTANCIA.listaCategoriaProductoAListaCategoriaProductoDTO(categoriaProductoRepository.findAll());
    }

    @Override
    public CategoriaProductoDTO obtenerCategoriaProductoPorID(long id) {
        return categoriaProductoRepository.findById(id)
                .map(CategoriaProductoMapper.INSTANCIA::categoriaProductoACategoriaProductoDTO)
                .orElse(null);
    }

    @Override
    public CategoriaProductoDTO registrarCategoriaProducto(CategoriaProductoCreateDTO categoriaProductoCreateDTO) {
        CategoriaProducto categoriaProducto = CategoriaProductoMapper.INSTANCIA.categoriaProductoCreateDTOACategoriaProducto(categoriaProductoCreateDTO);
        CategoriaProducto respuestaEntity = categoriaProductoRepository.save(categoriaProducto);
        CategoriaProductoDTO respuestaDTO = CategoriaProductoMapper.INSTANCIA.categoriaProductoACategoriaProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public CategoriaProductoDTO actualizarCategoriaProducto(CategoriaProductoUpdateDTO categoriaProductoUpdateDTO) {
        CategoriaProducto categoriaProducto = CategoriaProductoMapper.INSTANCIA.categoriaProductoUpdateDTOACategoriaProducto(categoriaProductoUpdateDTO);
        CategoriaProducto respuestaEntity = categoriaProductoRepository.save(categoriaProducto);
        CategoriaProductoDTO respuestaDTO = CategoriaProductoMapper.INSTANCIA.categoriaProductoACategoriaProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCategoriaProducto(long id) {
        Optional<CategoriaProducto> categoriaProductoOptional = categoriaProductoRepository.findById(id);
        categoriaProductoOptional.ifPresentOrElse(
                categoriaProducto -> categoriaProductoRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró la categoría de producto con id = " + id);
                }
        );
        return "Categoría de producto eliminada";
    }
}
