package com.saludnativa.controller;

import com.saludnativa.dtos.ProveedorCreateDTO;
import com.saludnativa.dtos.ProveedorDTO;
import com.saludnativa.dtos.ProveedorUpdateDTO;
import com.saludnativa.service.ProveedorService;
import com.saludnativa.service.TipoDocIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private TipoDocIdentidadService tipoDocIdentidadService;

    @GetMapping("/proveedores")
    public ResponseEntity<List<ProveedorDTO>> listarProveedores() {
        return new ResponseEntity<>(proveedorService.listarProveedores(), HttpStatus.OK);
    }

    @GetMapping("/proveedoresactivos")
    public ResponseEntity<List<ProveedorDTO>> listarProveedoresActivos() {
        List<ProveedorDTO> proveedoresActivos = proveedorService.listarProveedoresActivos();
        return new ResponseEntity<>(proveedoresActivos, HttpStatus.OK);
    }

    @GetMapping("/proveedores/{proveedorId}")
    public ResponseEntity<ProveedorDTO> obtenerProveedorPorId(@PathVariable("proveedorId") long proveedorId) {
        return new ResponseEntity<>(proveedorService.obtenerProveedorPorID(proveedorId), HttpStatus.OK);
    }

    @PostMapping("/proveedores")
    public ResponseEntity<ProveedorDTO> registrarProveedor(@RequestBody ProveedorCreateDTO proveedorCreateDTO) {
        return new ResponseEntity<>(proveedorService.registrarProveedor(proveedorCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/proveedores")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@RequestBody ProveedorUpdateDTO proveedorUpdateDTO) {
        return new ResponseEntity<>(proveedorService.actualizarProveedor(proveedorUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/proveedores/{proveedorId}")
    public ResponseEntity<ProveedorDTO> eliminarProveedor(@PathVariable("proveedorId") long proveedorId) {
        return new ResponseEntity<>(proveedorService.eliminarProveedor(proveedorId), HttpStatus.OK);
    }
}
