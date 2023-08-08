package com.saludnativa.controller;

import com.saludnativa.dtos.DepartamentoDTO;
import com.saludnativa.dtos.ProvinciaDTO;
import com.saludnativa.dtos.DistritoDTO;
import com.saludnativa.service.ProvinciaService;
import com.saludnativa.service.DepartamentoService;
import com.saludnativa.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UbigeoPeruController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/provincias")
    public ResponseEntity<List<ProvinciaDTO>> getAllProvincias() {
        List<ProvinciaDTO> provincias = provinciaService.getAllProvincias();
        return ResponseEntity.ok(provincias);
    }

    @GetMapping("/departamentos/{provinciaId}")
    public ResponseEntity<List<DepartamentoDTO>> getDepartmentsByProvince(@PathVariable String provinciaId) {
        List<DepartamentoDTO> departamentos = departamentoService.getDepartmentsByProvince(provinciaId);
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/distritos/{departamentoId}/{provinciaId}")
    public ResponseEntity<List<DistritoDTO>> getDistrictsByDepartmentAndProvince(
            @PathVariable String departamentoId, @PathVariable String provinciaId) {
        List<DistritoDTO> distritos = distritoService.getDistrictsByDepartmentAndProvince(departamentoId, provinciaId);
        return ResponseEntity.ok(distritos);
    }
}
