package com.saludnativa.dtos;

import com.saludnativa.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorDTO {

    private Long id_proveedor ;
    private String nombre_proveedor  ;
    private String contacto_proveedor  ;
    private String email_proveedor ;
    private String celular_proveedor  ;
    private Estado estado ;
}
