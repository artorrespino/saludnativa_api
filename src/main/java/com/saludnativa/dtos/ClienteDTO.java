package com.saludnativa.dtos;

import com.saludnativa.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
public class ClienteDTO {

    private Long id_cliente;
    private Usuario usuario;
    private LocalDate fec_nacimiento;
    private TipoDocIdentidad tipoDocIdentidad;
    private String num_doc_identidad;
    private String direccion;
    //private Distrito distrito;
    //private Provincia provincia;
    //private Departamento departamento;
    private EstadoUsuario estadoUsuario;
}
