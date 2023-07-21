package com.saludnativa.repository;

import com.saludnativa.model.DetalleCarritoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCarritoComprasRepository extends JpaRepository<DetalleCarritoCompras, Long> {

    @Query("SELECT dc FROM DetalleCarritoCompras dc WHERE dc.carritoCompras.id = ?1")
    List<DetalleCarritoCompras> findByCarritoCompras_Id_Carrito(Long id_carrito);
}
