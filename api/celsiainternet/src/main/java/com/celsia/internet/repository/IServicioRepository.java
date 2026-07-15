package com.celsia.internet.repository;

import com.celsia.internet.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio,Long> {

    boolean existsByIdentificacion(String identificacion);

    Optional<Servicio> findByIdentificacion(String identificacion);

    List<Servicio> findByClienteIdentificacion(String identificacion);

}
