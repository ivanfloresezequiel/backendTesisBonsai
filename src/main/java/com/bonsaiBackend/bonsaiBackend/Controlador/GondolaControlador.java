package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Gondola;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Servicio.GondolaServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;

@CrossOrigin("*")
@RestController
@RequestMapping({"/gondolas"})


public class GondolaControlador {

    @Autowired
    GondolaServicio gondolaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = gondolaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Gondola gondola) throws Exception {
        Response response = gondolaServicio.guardarGondola(gondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = gondolaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Gondola gondola, @PathVariable("id")Integer id){
        gondola.setId_gondola(id);
        //System.out.println("acavoy");
        Response response= gondolaServicio.editar(gondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
