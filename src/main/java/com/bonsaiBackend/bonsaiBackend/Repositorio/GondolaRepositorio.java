package com.bonsaiBackend.bonsaiBackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bonsaiBackend.bonsaiBackend.Modelo.Gondola;
import org.springframework.stereotype.Repository;

@Repository

public interface GondolaRepositorio extends JpaRepository<Gondola, Integer>{
}
