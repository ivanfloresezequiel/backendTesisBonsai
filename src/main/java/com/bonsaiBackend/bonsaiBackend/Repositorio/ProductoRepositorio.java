package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoPrueba;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends  JpaRepository<ProductoPrueba, Integer>{
   List<ProductoRepositorio> findByNombre(String nombre);

}
