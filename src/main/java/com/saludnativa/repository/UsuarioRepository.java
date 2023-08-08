package com.saludnativa.repository;

import com.saludnativa.model.Proveedor;
import com.saludnativa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT p FROM Usuario p WHERE p.estado.id_estado = ?1")
    List<Usuario> findByEstadoIdEstado(Long id_estado);
}
