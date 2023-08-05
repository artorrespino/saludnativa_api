package com.saludnativa.controller;

import com.saludnativa.dtos.EstadoCreateDTO;
import com.saludnativa.dtos.EstadoDTO;
import com.saludnativa.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

    @Autowired
    private EstadoService EstadoService;

    @GetMapping("estados")
    public ResponseEntity<List<EstadoDTO>> listarestados(){
        return new ResponseEntity<>(EstadoService.listarEstado(), HttpStatus.OK);
    }

    @GetMapping("/estados/{estadoId}")
    public ResponseEntity<EstadoDTO> obtenerEstadoPorId(@PathVariable("estadoId") long estadoId){
        return new ResponseEntity<>(EstadoService.obtenerEstadoPorID(estadoId),HttpStatus.OK);
    }

    @PostMapping("estados")
    public ResponseEntity<EstadoDTO> registrarEstado(@RequestBody EstadoCreateDTO estadoCreateDTO){
        return new ResponseEntity<>(EstadoService.registrarEstado(estadoCreateDTO),HttpStatus.OK);
    }

}
