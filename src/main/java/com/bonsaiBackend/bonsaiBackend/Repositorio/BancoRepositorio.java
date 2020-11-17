package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BancoRepositorio extends JpaRepository<Banco, Integer> {

    @Query("SELECT r FROM Banco r WHERE r.id_banco = :id")
    Banco findById_banco(@Param("id")Integer id);
    List<Banco> findAllByEstadoTrue();
}
