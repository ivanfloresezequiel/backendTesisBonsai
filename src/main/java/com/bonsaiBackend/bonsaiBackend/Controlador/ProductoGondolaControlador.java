package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Modelo.ProductoGondola;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoGondolaServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;

@CrossOrigin("*")
@RestController
@RequestMapping({"/producto_gondolas"})


public class ProductoGondolaControlador {

    @Autowired
    ProductoGondolaServicio productoGondolaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = productoGondolaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody ProductoGondola productoGondola) throws Exception {
        Response response = productoGondolaServicio.guardarProductoGondola(productoGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = productoGondolaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody ProductoGondola productoGondola, @PathVariable("id")Integer id){
        productoGondola.setId_producto_gondola(id);
        //System.out.println("acavoy");
        Response response= productoGondolaServicio.editar(productoGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
