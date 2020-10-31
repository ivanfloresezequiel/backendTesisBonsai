package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

import com.bonsaiBackend.bonsaiBackend.Repositorio.CategoriaRepositorio;

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

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Categoria> categoria = categoriaRepositorio.findById(id);
        response.setData(categoria);
        return response;
    }
    public Response editar(Categoria categoria){
        Response response = new Response();
        Categoria categoriaGuardado = categoriaRepositorio.save(categoria);
        response.setData(categoriaGuardado);
        return response;
    }
    public Response listarHabilitados(){
        Response response = new Response();
        List<Categoria> categorias = categoriaRepositorio.findAll();
        response.setCode(200);
        response.setMsg("Lista de Categorias");
        response.setData(categorias);
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