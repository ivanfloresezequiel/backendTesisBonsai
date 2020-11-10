package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Marca;
import com.bonsaiBackend.bonsaiBackend.Repositorio.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServicio {

    @Autowired
    MarcaRepositorio marcaRepositorio;




    public Response listar() throws Exception {
        Response response = new Response();
        List<Marca> marcas = marcaRepositorio.findAll();
        if (marcas == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Marca");
        response.setData(marcas);
        return response;
    }

    public Response guardarCategoria(Marca categoria) throws Exception {
        Response response = new Response();

        Marca marcaToSave = marcaRepositorio.save(categoria);

        if (marcaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Marca Guardada Exitosamente");
        response.setData(marcaToSave);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Marca> marca = marcaRepositorio.findById(id);
        response.setData(marca);
        return response;
    }
    public Response editar(Marca marca){
        Response response = new Response();
        Marca marcaGuardado = marcaRepositorio.save(marca);
        response.setData(marcaGuardado);
        return response;
    }
    public Response ListarHabilitados(){
        Response response = new Response();
        List<Marca> marcas = marcaRepositorio.findAllByEstadoTrue();
        response.setCode(200);
        response.setMsg("Lista de Categorias");
        response.setData(marcas);
        return response;
    }
}