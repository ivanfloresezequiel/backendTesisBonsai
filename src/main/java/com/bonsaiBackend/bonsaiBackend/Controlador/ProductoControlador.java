package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;

@CrossOrigin("*")
@RestController
@RequestMapping({"/productos"})

public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = productoServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Producto producto) throws Exception {
        Response response = productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = productoServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Producto producto, @PathVariable("id")Integer id){
        producto.setId_producto(id);
        System.out.println("acavoy");
        Response response= productoServicio.editar(producto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
