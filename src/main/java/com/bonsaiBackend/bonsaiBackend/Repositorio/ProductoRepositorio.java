package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByEstadoTrue();
}
