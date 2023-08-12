package com.saludnativa.repository;

import com.saludnativa.model.Departamento;
import com.saludnativa.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,String> {

    List<Provincia> findProvinciasByDepartamento(Departamento departamento);

}
