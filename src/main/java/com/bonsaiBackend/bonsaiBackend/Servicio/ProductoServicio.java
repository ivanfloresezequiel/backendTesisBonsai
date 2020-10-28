package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoPrueba;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio  {
    @Autowired
    ProductoRepositorio productoRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<ProductoPrueba> productos = productoRepositorio.findAll();
        if(productos == null){
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista Productos");
        response.setData(productos);
        return response;
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<ProductoPrueba> producto = productoRepositorio.findById(id);
        response.setData(producto);
        return response;
    }

}
