package com.bonsaiBackend.bonsaiBackend.Repositorio;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer>{
    List<Proveedor> findAllByEstadoTrue();
}
