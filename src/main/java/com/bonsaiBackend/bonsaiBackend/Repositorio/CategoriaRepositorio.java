package com.bonsaiBackend.bonsaiBackend.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{
    /*Categoria fndById_categoria(int id);*/
}


