package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    ProductoRepositorio productoRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<Producto> productos = productoRepositorio.findAll();
        if (productos == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Productos");
        response.setData(productos);
        return response;
    }

    public Response guardarProducto(Producto producto) throws Exception {
        Response response = new Response();

        Producto productoToSave = productoRepositorio.save(producto);

        if (productoToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Producto Guardado Exitosamente");
        response.setData(productoToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Producto> producto = productoRepositorio.findById(id);
        response.setData(producto);
        return response;
    }
    public Response editar(Producto producto){
        Response response = new Response();
        Producto productoGuardado = productoRepositorio.save(producto);
        response.setData(productoRepositorio);
        return response;
    }
}
