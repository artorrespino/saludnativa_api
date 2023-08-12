package com.saludnativa.service;

import com.saludnativa.dtos.ClienteCreateDTO;
import com.saludnativa.dtos.ClienteDTO;
import com.saludnativa.dtos.ClienteUpdateDTO;
import com.saludnativa.mappers.ClienteMapper;
import com.saludnativa.model.Cliente;
import com.saludnativa.model.Estado;
import com.saludnativa.model.TipoDocIdentidad;
import com.saludnativa.repository.ClienteRepository;
import com.saludnativa.repository.EstadoRepository;
import com.saludnativa.repository.TipoDocIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipoDocIdentidadRepository tipoDocIdentidadRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<ClienteDTO> listarClientes() {
        return ClienteMapper.INSTANCIA.listaClienteAListaClienteDTO(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientesPorID(long id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper.INSTANCIA::clienteAClienteDTO)
                .orElse(null);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {

        Cliente cliente = ClienteMapper.INSTANCIA.clienteCreateDTOACliente(clienteCreateDTO);

//--------CÓDIGO PARA VALIDAR EXISTENCIA DE ID DE TIPO DE DOCUMENTO INGRESADO---------------------------
        // Obtener el objeto TipoDocumento correspondiente desde el repositorio por su id
        TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadRepository.findById(clienteCreateDTO.getTipoDocIdentidad().getId_tipo_doc_identidad())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de documento no encontrado"));

        cliente.setTipoDocIdentidad(tipoDocIdentidad); // Establecer el TipoDocumento en el Cliente
//----------------------------------------------------------------------------------------------------
        Estado estadoActivo = estadoRepository.findById(1L).orElse(null);// Obtener el estado activo desde la base de datos por su ID
        cliente.setEstado(estadoActivo);// Asignar el estado activo al usuario antes de guardarlo

        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {

        Cliente cliente = ClienteMapper.INSTANCIA.clienteUpdateDTOCliente(clienteUpdateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO eliminarCliente(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Estado estadoEliminado = new Estado();
            estadoEliminado.setId_estado(2L); // Depende de la tb_estado_usuario ID del estado "eliminado" es 3
            cliente.setEstado(estadoEliminado);
            clienteRepository.save(cliente);
            ClienteDTO clienteDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(cliente);
            return clienteDTO;
        } else {
            throw new NoSuchElementException("No se encontró el cliente con ID = " + id);
        }
    }
}
