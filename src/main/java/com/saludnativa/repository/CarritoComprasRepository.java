package com.saludnativa.repository;

import com.saludnativa.model.CarritoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {
}
