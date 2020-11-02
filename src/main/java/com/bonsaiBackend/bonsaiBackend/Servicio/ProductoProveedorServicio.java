package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoProveedor;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoProveedorRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class ProductoProveedorServicio {

    @Autowired
    ProductoProveedorRepositorio productoProveedorRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<ProductoProveedor> productoProveedor = productoProveedorRepositorio.findAll();
        if (productoProveedor == null) {
            throw new Exception();
        }
        response.setCode(200);
        //response.setMsg("Lista de Productos");
        response.setData(productoProveedor);
        return response;
    }

    public Response guardarProductoProveedor(ProductoProveedor productoProveedor) throws Exception {
        Response response = new Response();

        ProductoProveedor productoProveedorToSave = productoProveedorRepositorio.save(productoProveedor);

        if (productoProveedorToSave == null)
            throw new Exception();
        response.setCode(200);
        //response.setMsg("Producto Guardado Exitosamente");
        response.setData(productoProveedorToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<ProductoProveedor> productoProveedor = productoProveedorRepositorio.findById(id);
        response.setData(productoProveedor);
        return response;
    }
    public Response editar(ProductoProveedor productoProveedor){
        Response response = new Response();
        ProductoProveedor productoProveedorGuardado = productoProveedorRepositorio.save(productoProveedor);
        response.setData(productoProveedorRepositorio);
        return response;
    }
}
