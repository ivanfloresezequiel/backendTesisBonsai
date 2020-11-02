package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProveedorServicio {
    @Autowired
    ProveedorRepositorio proveedorRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<Proveedor> proveedores = proveedorRepositorio.findAll();
        if (proveedores == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Proveedores");
        response.setData(proveedores);
        return response;
    }

    public Response guardarProveedor(Proveedor proveedor) throws Exception {
        Response response = new Response();

        Proveedor proveedorToSave = proveedorRepositorio.save(proveedor);

        if (proveedorToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Proveedor Guardado Exitosamente");
        response.setData(proveedorToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Proveedor> proveedor = proveedorRepositorio.findById(id);
        response.setData(proveedor);
        return response;
    }
    public Response editar(Proveedor proveedor){
        Response response = new Response();
        Proveedor proveedorGuardado = proveedorRepositorio.save(proveedor);
        response.setData(proveedorRepositorio);
        return response;
    }
}
