package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.ReposicionGondola;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ReposicionGondolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReposicionGondolaServicio {

    @Autowired
    ReposicionGondolaRepositorio reposicionGondolaRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<ReposicionGondola> reposicionGondolas = reposicionGondolaRepositorio.findAll();
        if (reposicionGondolas == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Reposicion de Góndolas");
        response.setData(reposicionGondolas);
        return response;
    }

    public Response guardarReposicionGondolas(ReposicionGondola reposicionGondola) throws Exception {
        Response response = new Response();

        ReposicionGondola reposicionGondolaToSave = reposicionGondolaRepositorio.save(reposicionGondola);

        if (reposicionGondola == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Reposicion de góndola Guardada Exitosamente");
        response.setData(reposicionGondolaToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<ReposicionGondola> reposicionGondola = reposicionGondolaRepositorio.findById(id);
        response.setData(reposicionGondola);
        return response;
    }
    public Response editar(ReposicionGondola reposicionGondola){
        Response response = new Response();
        ReposicionGondola ReposicionGondolaGuardado = reposicionGondolaRepositorio.save(reposicionGondola);
        response.setData(reposicionGondola);
        return response;
    }
}
