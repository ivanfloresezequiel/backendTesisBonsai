package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoPrueba;
import com.bonsaiBackend.bonsaiBackend.Repositorio.CategoriaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {
    @Autowired
    CategoriaRepositorio categoriaRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<Categoria> categorias = categoriaRepositorio.findAll();
        if (categorias == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Categorias");
        response.setData(categorias);
        return response;
    }

    public Response guardarCategoria(Categoria categoria) throws Exception {
        Response response = new Response();

        Categoria categoriaToSave = categoriaRepositorio.save(categoria);

        if (categoriaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Categoria Guardada Exitosamente");
        response.setData(categoriaToSave);
        return response;
    }


    /*public Response actualizarCategoria (Categoria categoria) throws Exception {
        Response response = new Response();
        Categoria categoriaToUpdate = categoriaRepositorio.fndById_categoria(categoria.getId_categoria());

        if (categoriaToUpdate == null) {
            throw new Exception();
        }

        categoriaToUpdate.setDescripcion(categoria.getDescripcion());
        categoriaToUpdate.setEtiqueta(categoria.getEtiqueta());

        response.setCode(200);
        response.setMsg("Banco actualizado con exito");
        response.setData(categoriaRepositorio.save(categoriaToUpdate));
        return response;
    }*/
}