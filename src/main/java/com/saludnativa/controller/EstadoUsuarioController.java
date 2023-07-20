package com.saludnativa.controller;

import com.saludnativa.dtos.*;
import com.saludnativa.service.EstadoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins ="http://localhost:4200")
public class EstadoUsuarioController {

    @Autowired
    private EstadoUsuarioService estadoUsuarioService;

    @GetMapping("estadoUsuarios")
    public ResponseEntity<List<EstadoUsuarioDTO>> listarEstadoUsuarios(){
        return new ResponseEntity<>(estadoUsuarioService.listarEstadoUsurio(), HttpStatus.OK);
    }

    @GetMapping("/estadoUsuarios/{estadoUsuarioId}")
    public ResponseEntity<EstadoUsuarioDTO> obtenerEstadoUsuarioPorId(@PathVariable("estadoUsuarioId") long estadoUsuarioId){
        return new ResponseEntity<>(estadoUsuarioService.obtenerEstadoUsuarioPorID(estadoUsuarioId),HttpStatus.OK);
    }

    @PostMapping("estadoUsuarios")
    public ResponseEntity<EstadoUsuarioDTO> registrarEstadoUsuario(@RequestBody EstadoUsuarioCreateDTO estadoUsuarioCreateDTO){
        return new ResponseEntity<>(estadoUsuarioService.registrarEstadoUsuario(estadoUsuarioCreateDTO),HttpStatus.OK);
    }

    @PutMapping("estadoUsuarios")
    public ResponseEntity<EstadoUsuarioDTO> actualizarEstadoUsuario(@RequestBody EstadoUsuarioUpdateDTO estadoUsuarioUpdateDTO){
        return new ResponseEntity<>(estadoUsuarioService.actualizarEstadoUsuario(estadoUsuarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/estadoUsuarios/{estadoUsuarioId}")
    public ResponseEntity<String> eliminarEstadoUsuario(@PathVariable("estadoUsuarioId") long estadoUsuarioId){
        return new ResponseEntity<>(estadoUsuarioService.eliminarEstadoUsuario(estadoUsuarioId),HttpStatus.OK);
    }
}
