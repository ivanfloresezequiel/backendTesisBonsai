package com.bonsaiBackend.bonsaiBackend.Servicio;


import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.TipoGondola;

import com.bonsaiBackend.bonsaiBackend.Repositorio.TipoGondolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TipoGondolaServicio {

    @Autowired
    TipoGondolaRepositorio tipoGondolaRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<TipoGondola> tipoGondola = tipoGondolaRepositorio.findAll();
        if (tipoGondola == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Tipos de Gondolas");
        response.setData(tipoGondola);
        return response;
    }

    public Response guardarTipoGondola(TipoGondola tipoGondola) throws Exception {
        Response response = new Response();

        TipoGondola tipoGondolaToSave = tipoGondolaRepositorio.save(tipoGondola);

        if (tipoGondolaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Tipo de Góndola Guardado Exitosamente");
        response.setData(tipoGondolaToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<TipoGondola> tipoGondola = tipoGondolaRepositorio.findById(id);
        response.setData(tipoGondola);
        return response;
    }
    public Response editar(TipoGondola tipoGondola){
        Response response = new Response();
        TipoGondola tipoGondolaGuardado = tipoGondolaRepositorio.save(tipoGondola);
        response.setData(tipoGondolaRepositorio);
        return response;
    }
}
