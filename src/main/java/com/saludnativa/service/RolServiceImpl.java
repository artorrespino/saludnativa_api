package com.saludnativa.service;

import com.saludnativa.dtos.RolCreateDTO;
import com.saludnativa.dtos.RolDTO;
import com.saludnativa.dtos.RolUpdateDTO;
import com.saludnativa.mappers.RolMapper;
import com.saludnativa.model.Rol;
import com.saludnativa.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolDTO> listarRol() {
        return RolMapper.INSTANCIA.listaRolAlistaRolDTO(rolRepository.findAll());
    }

    @Override
    public RolDTO obtenerRolPorID(long id) {
        return rolRepository.findById(id)
                .map(RolMapper.INSTANCIA::rolARolDTO)
                .orElse(null);

    }

    @Override
    public RolDTO registrarRol(RolCreateDTO rolCreateDTO) {
        Rol rol = RolMapper.INSTANCIA.rolCreateDTOARol(rolCreateDTO);
        Rol respuestaEntity = rolRepository.save(rol);
        RolDTO respuestaDTO = RolMapper.INSTANCIA.rolARolDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO) {
        Rol rol = RolMapper.INSTANCIA.rolUpdateDTOARol(rolUpdateDTO);
        Rol respuestaEntity = rolRepository.save(rol);
        RolDTO respuestaDTO = RolMapper.INSTANCIA.rolARolDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarRol(long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        rolOptional.ifPresentOrElse(
                rol -> rolRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró el rol con id = " + id);
                }
        );
        return "Registro de rol eliminado";
    }
}
