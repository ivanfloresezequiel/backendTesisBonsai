package com.bonsaiBackend.bonsaiBackend.Controlador;


import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Servicio.CategoriaServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.PruebaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping({"/prueba"})

public class PruebaControlador {

    @Autowired
    PruebaServicio pruebaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = pruebaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


