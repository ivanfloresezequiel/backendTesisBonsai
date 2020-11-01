package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Gondola;

import com.bonsaiBackend.bonsaiBackend.Repositorio.GondolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GondolaServicio {

    @Autowired
    GondolaRepositorio gondolaRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<Gondola> gondolas = gondolaRepositorio.findAll();
        if (gondolas  == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Gondolas");
        response.setData(gondolas);
        return response;
    }

    public Response guardarGondola(Gondola gondola) throws Exception {
        Response response = new Response();

        Gondola gondolaToSave = gondolaRepositorio.save(gondola);

        if (gondolaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Gondola Guardada Exitosamente");
        response.setData(gondolaToSave);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Gondola> gondola = gondolaRepositorio.findById(id);
        response.setData(gondola);
        return response;
    }
    public Response editar(Gondola gondola){
        Response response = new Response();
        Gondola gondolaGuardado = gondolaRepositorio.save(gondola);
        response.setData(gondolaGuardado);
        return response;
    }
    public Response listarHabilitados(){
        Response response = new Response();
        List<Gondola> gondolas = gondolaRepositorio.findAll();
        response.setCode(200);
        response.setMsg("Lista de Gondolas");
        response.setData(gondolas);
        return response;
    }
}
