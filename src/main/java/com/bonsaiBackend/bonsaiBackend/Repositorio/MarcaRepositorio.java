package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {

    List<Marca> findAllByEstadoTrue();
}
