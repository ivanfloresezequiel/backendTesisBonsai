package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Presentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PresentaciónRepositorio extends JpaRepository<Presentacion, Integer> {
    List<Presentacion> findAllByEstadoTrue();
}
