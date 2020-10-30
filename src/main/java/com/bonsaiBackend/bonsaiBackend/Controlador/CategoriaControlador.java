package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

@CrossOrigin("*")
@RestController
@RequestMapping({"/categoria"})
public class CategoriaControlador {
    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = categoriaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.guardarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*@PutMapping
    public ResponseEntity<Response> actualizar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.actualizarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}