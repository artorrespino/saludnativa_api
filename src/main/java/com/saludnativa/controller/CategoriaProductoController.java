package com.saludnativa.controller;

import com.saludnativa.dtos.CategoriaProductoCreateDTO;
import com.saludnativa.dtos.CategoriaProductoDTO;
import com.saludnativa.dtos.CategoriaProductoUpdateDTO;
import com.saludnativa.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaProductoDTO>> listarCategoriasProductos(){
        return new ResponseEntity<>(categoriaProductoService.listarCategoriasProducto(), HttpStatus.OK);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<CategoriaProductoDTO> obtenerCategoriaProductoPorId(@PathVariable("categoriaId") long categoriaId){
        return new ResponseEntity<>(categoriaProductoService.obtenerCategoriaProductoPorID(categoriaId), HttpStatus.OK);
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaProductoDTO> registrarCategoriaProducto(@RequestBody CategoriaProductoCreateDTO categoriaProductoCreateDTO){
        return new ResponseEntity<>(categoriaProductoService.registrarCategoriaProducto(categoriaProductoCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/categorias")
    public ResponseEntity<CategoriaProductoDTO> actualizarCategoriaProducto(@RequestBody CategoriaProductoUpdateDTO categoriaProductoUpdateDTO){
        return new ResponseEntity<>(categoriaProductoService.actualizarCategoriaProducto(categoriaProductoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/categorias/{categoriaId}")
    public ResponseEntity<String> eliminarCategoriaProducto(@PathVariable("categoriaId") long categoriaId){
        return new ResponseEntity<>(categoriaProductoService.eliminarCategoriaProducto(categoriaId), HttpStatus.OK);
    }
}
