package com.bonsaiBackend.bonsaiBackend.Servicio;
import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Gondola;

import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoGondola;
import com.bonsaiBackend.bonsaiBackend.Repositorio.GondolaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoGondolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoGondolaServicio {
    @Autowired
    ProductoGondolaRepositorio productoGondolaRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<ProductoGondola> productoGondola = productoGondolaRepositorio.findAll();
        if (productoGondola  == null) {
            throw new Exception();
        }
        response.setCode(200);
        //response.setMsg("Lista de Gondolas");
        response.setData(productoGondola);
        return response;
    }

    public Response guardarProductoGondola(ProductoGondola productoGondola) throws Exception {
        Response response = new Response();

        ProductoGondola productoGondolaToSave = productoGondolaRepositorio.save(productoGondola);

        if (productoGondolaToSave == null)
            throw new Exception();
        response.setCode(200);
        //response.setMsg("Gondola Guardada Exitosamente");
        response.setData(productoGondolaToSave);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<ProductoGondola> productoGondola = productoGondolaRepositorio.findById(id);
        response.setData(productoGondola);
        return response;
    }
    public Response editar(ProductoGondola productoGondola){
        Response response = new Response();
        ProductoGondola productoGondolaGuardado = productoGondolaRepositorio.save(productoGondola);
        response.setData(productoGondolaGuardado);
        return response;
    }
    public Response listarHabilitados(){
        Response response = new Response();
        List<ProductoGondola> productoGondolas = productoGondolaRepositorio.findAll();
        response.setCode(200);
        //response.setMsg("Lista de Gondolas");
        response.setData(productoGondolas);
        return response;
    }
}
