package com.bonsaiBackend.bonsaiBackend.Repositorio;
import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;

import com.bonsaiBackend.bonsaiBackend.Modelo.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface CuentaBancariaRepositorio extends JpaRepository<CuentaBancaria, Integer> {
    /*Categoria fndById_categoria(int id);*/
    List<CuentaBancaria> findAllByEstadoTrue();
}
