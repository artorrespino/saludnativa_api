package com.saludnativa.repository;

import com.saludnativa.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    @Query("SELECT p FROM Proveedor p WHERE p.estado.id_estado = ?1")
    List<Proveedor> findByEstadoIdEstado(Long id_estado);


}
