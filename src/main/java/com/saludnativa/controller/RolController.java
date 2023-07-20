package com.saludnativa.controller;

import com.saludnativa.dtos.RolCreateDTO;
import com.saludnativa.dtos.RolDTO;
import com.saludnativa.dtos.RolUpdateDTO;
import com.saludnativa.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins ="http://localhost:4200")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("rol")
    public ResponseEntity<List<RolDTO>> listarRols(){
        return new ResponseEntity<>(rolService.listarRol(), HttpStatus.OK);
    }

    @GetMapping("/rol/{rolId}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable("rolId") long rolId){
        return new ResponseEntity<>(rolService.obtenerRolPorID(rolId),HttpStatus.OK);
    }

    @PostMapping("rol")
    public ResponseEntity<RolDTO> registrarRol(@RequestBody RolCreateDTO rolCreateDTO){
        return new ResponseEntity<>(rolService.registrarRol(rolCreateDTO),HttpStatus.OK);
    }

    @PutMapping("rol")
    public ResponseEntity<RolDTO> actualizarRol(@RequestBody RolUpdateDTO rolUpdateDTO){
        return new ResponseEntity<>(rolService.actualizarRol(rolUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/rol/{rolId}")
    public ResponseEntity<String> eliminarRol(@PathVariable("rolId") long rolId){
        return new ResponseEntity<>(rolService.eliminarRol(rolId),HttpStatus.OK);
    }
}
