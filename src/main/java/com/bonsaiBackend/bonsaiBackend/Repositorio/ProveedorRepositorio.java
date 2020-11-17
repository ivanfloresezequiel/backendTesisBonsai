package com.bonsaiBackend.bonsaiBackend.Repositorio;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer>{
    @Query("SELECT r FROM Proveedor r WHERE r.id_proveedor = :id")
    Proveedor findById_proveedor(@Param("id") Integer id);
    List<Proveedor> findAllByEstadoTrue();
}
