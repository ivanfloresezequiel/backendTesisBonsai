package com.bonsaiBackend.bonsaiBackend.Servicio;
import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Marca;
import com.bonsaiBackend.bonsaiBackend.Modelo.Presentacion;
import com.bonsaiBackend.bonsaiBackend.Repositorio.MarcaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.PresentaciónRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class PresentacionServicio {

    @Autowired
    PresentaciónRepositorio presentaciónRepositorio;




    public Response listar() throws Exception {
        Response response = new Response();
        List<Presentacion> presentaciones = presentaciónRepositorio.findAll();
        if (presentaciones == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Presentaciones");
        response.setData(presentaciones);
        return response;
    }

    public Response guardarPresentacion(Presentacion presentacion) throws Exception {
        Response response = new Response();

        Presentacion presentacionToSave = presentaciónRepositorio.save(presentacion);

        if (presentacionToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Presentacion Guardada Exitosamente");
        response.setData(presentacionToSave);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Presentacion> marca = presentaciónRepositorio.findById(id);
        response.setData(marca);
        return response;
    }
    public Response editar(Presentacion presentacion){
        Response response = new Response();
        Presentacion presentacionGuardado = presentaciónRepositorio.save(presentacion);
        response.setData(presentacionGuardado);
        return response;
    }
    public Response ListarHabilitados(){
        Response response = new Response();
        List<Presentacion> presentaciones = presentaciónRepositorio.findAllByEstadoTrue();
        response.setCode(200);
        response.setMsg("Lista de Presentaciones");
        response.setData(presentaciones);
        return response;
    }
}
