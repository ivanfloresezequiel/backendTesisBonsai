package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BancoRepositorio extends JpaRepository<Banco, Integer> {
    /*Categoria fndById_categoria(int id);*/
    List<Banco> findAllByEstadoTrue();
}
