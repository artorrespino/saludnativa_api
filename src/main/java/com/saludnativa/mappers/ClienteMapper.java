package com.saludnativa.mappers;

import com.saludnativa.dtos.ClienteCreateDTO;
import com.saludnativa.dtos.ClienteDTO;
import com.saludnativa.dtos.ClienteUpdateDTO;
import com.saludnativa.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCIA = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOCliente(ClienteUpdateDTO clienteUpdateDTO);

    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);
}
