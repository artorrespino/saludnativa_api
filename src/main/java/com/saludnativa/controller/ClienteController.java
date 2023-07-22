package com.saludnativa.controller;

import com.saludnativa.dtos.ClienteCreateDTO;
import com.saludnativa.dtos.ClienteDTO;
import com.saludnativa.dtos.ClienteUpdateDTO;
import com.saludnativa.repository.service.ClienteService;
import com.saludnativa.repository.service.TipoDocIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TipoDocIdentidadService tipoDocIdentidadService;

    @GetMapping("clientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("clienteId") long clienteId){
        return new ResponseEntity<>(clienteService.obtenerClientesPorID(clienteId),HttpStatus.OK);
    }

    @PostMapping("clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){

        return new ResponseEntity<>(clienteService.registrarCliente(clienteCreateDTO), HttpStatus.OK);
    }

    @PutMapping("clientes")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return new ResponseEntity<>(clienteService.actualizarCliente(clienteUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("clienteId") long clienteId){
        return new ResponseEntity<>(clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }
}
