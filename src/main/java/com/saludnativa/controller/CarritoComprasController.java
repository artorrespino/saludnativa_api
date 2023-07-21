package com.saludnativa.controller;

import com.saludnativa.dtos.CarritoComprasCreateDTO;
import com.saludnativa.dtos.CarritoComprasDTO;
import com.saludnativa.dtos.CarritoComprasUpdateDTO;
import com.saludnativa.service.CarritoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200")
public class CarritoComprasController {

    @Autowired
    private CarritoComprasService carritoComprasService;

    @GetMapping("/carritoCompras")
    public ResponseEntity<List<CarritoComprasDTO>> listarCarritoCompras() {
        return new ResponseEntity<>(carritoComprasService.listarCarritoCompras(), HttpStatus.OK);
    }

    @GetMapping("/carritoCompras/{carritoComprasId}")
    public ResponseEntity<CarritoComprasDTO> obtenerCarritoComprasPorId(@PathVariable("carritoComprasId") long carritoComprasId) {
        return new ResponseEntity<>(carritoComprasService.obtenerCarritoComprasPorID(carritoComprasId), HttpStatus.OK);
    }

    @PostMapping("/carritoCompras")
    public ResponseEntity<CarritoComprasDTO> registrarCarritoCompras(@RequestBody CarritoComprasCreateDTO carritoComprasCreateDTO) {
        return new ResponseEntity<>(carritoComprasService.registrarCarritoCompras(carritoComprasCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/carritoCompras")
    public ResponseEntity<CarritoComprasDTO> actualizarCarritoCompras(@RequestBody CarritoComprasUpdateDTO carritoComprasUpdateDTO) {
        return new ResponseEntity<>(carritoComprasService.actualizarCarritoCompras(carritoComprasUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/carritoCompras/{carritoComprasId}")
    public ResponseEntity<String> eliminarCarritoCompras(@PathVariable("carritoComprasId") long carritoComprasId) {
        return new ResponseEntity<>(carritoComprasService.eliminarCarritoCompras(carritoComprasId), HttpStatus.OK);
    }
}
