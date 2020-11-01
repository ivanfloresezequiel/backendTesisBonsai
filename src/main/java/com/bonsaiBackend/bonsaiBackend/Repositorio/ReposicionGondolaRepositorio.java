package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.ReposicionGondola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReposicionGondolaRepositorio extends JpaRepository<ReposicionGondola, Integer> {
}
