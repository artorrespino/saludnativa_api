package com.saludnativa.repository;

import com.saludnativa.model.EstadoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario,Long> {
}
