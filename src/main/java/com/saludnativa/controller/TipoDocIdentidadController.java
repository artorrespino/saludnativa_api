package com.saludnativa.controller;

import com.saludnativa.dtos.TipoDocIdentidadCreateDTO;
import com.saludnativa.dtos.TipoDocIdentidadDTO;
import com.saludnativa.dtos.TipoDocIdentidadUpdateDTO;
import com.saludnativa.service.TipoDocIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins ="http://localhost:4200")
public class TipoDocIdentidadController {

    @Autowired
    private TipoDocIdentidadService tipoDocIdentidadService;

    @GetMapping("tipoDocIdentidad")
    public ResponseEntity<List<TipoDocIdentidadDTO>> listarTipoDocIdentidads(){
        return new ResponseEntity<>(tipoDocIdentidadService.listarTipoDocIdentidad(), HttpStatus.OK);
    }

    @GetMapping("/tipoDocIdentidad/{tipoDocIdentidadId}")
    public ResponseEntity<TipoDocIdentidadDTO> obtenerTipoDocIdentidadPorId(@PathVariable("tipoDocIdentidadId") long tipoDocIdentidadId){
        return new ResponseEntity<>(tipoDocIdentidadService.obtenerTipoDocIdentidadPorID(tipoDocIdentidadId),HttpStatus.OK);
    }

    @PostMapping("tipoDocIdentidad")
    public ResponseEntity<TipoDocIdentidadDTO> registrarTipoDocIdentidad(@RequestBody TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO){
        return new ResponseEntity<>(tipoDocIdentidadService.registrarTipoDocIdentidad(tipoDocIdentidadCreateDTO),HttpStatus.OK);
    }

    @PutMapping("tipoDocIdentidad")
    public ResponseEntity<TipoDocIdentidadDTO> actualizarTipoDocIdentidad(@RequestBody TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO){
        return new ResponseEntity<>(tipoDocIdentidadService.actualizarTipoDocIdentidad(tipoDocIdentidadUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/tipoDocIdentidad/{tipoDocIdentidadId}")
    public ResponseEntity<String> eliminarTipoDocIdentidad(@PathVariable("TipoDocIdentidadId") long tipoDocIdentidadId){
        return new ResponseEntity<>(tipoDocIdentidadService.eliminarTipoDocIdentidad(tipoDocIdentidadId),HttpStatus.OK);
    }
}
