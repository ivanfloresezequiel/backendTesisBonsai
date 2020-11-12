package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;


import com.bonsaiBackend.bonsaiBackend.Repositorio.BancoRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.CategoriaRepositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class BancoServicio {

    @Autowired
    BancoRepositorio bancoRepositorio;



    public Response listar() throws Exception {
        Response response = new Response();
        List<Banco> bancos = bancoRepositorio.findAll();
        if (bancos   == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Bancos");
        response.setData(bancos);
        return response;
    }

    public Response guardarBanco(Banco banco) throws Exception {
        Response response = new Response();

        Banco bancoToSave = bancoRepositorio.save(banco);

        if (bancoToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Banco Guardado Exitosamente");
        response.setData(bancoToSave);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Banco> banco = bancoRepositorio.findById(id);
        response.setData(banco);
        return response;
    }
    public Response editar(Banco banco){
        Response response = new Response();
        Banco bancoGuardado = bancoRepositorio.save(banco);
        response.setData(bancoGuardado);
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
    public Response ListarHabilitados(){
        Response response = new Response();
        List<Banco> bancos = bancoRepositorio.findAllByEstadoTrue();
        response.setCode(200);
        response.setMsg("Lista de Bancos");
        response.setData(bancos);
        return response;
    }
}
