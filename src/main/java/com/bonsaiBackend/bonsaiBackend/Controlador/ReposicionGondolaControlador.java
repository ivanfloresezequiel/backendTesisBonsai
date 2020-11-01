package com.bonsaiBackend.bonsaiBackend.Controlador;


import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.ReposicionGondola;

import com.bonsaiBackend.bonsaiBackend.Servicio.ReposicionGondolaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping({"/reposicion_gondolas"})


public class ReposicionGondolaControlador {
    @Autowired
    ReposicionGondolaServicio reposicionGondolaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = reposicionGondolaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody ReposicionGondola reposicionGondola) throws Exception {
        Response response = reposicionGondolaServicio.guardarReposicionGondolas(reposicionGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = reposicionGondolaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody ReposicionGondola reposicionGondola, @PathVariable("id")Integer id){
        reposicionGondola.setId_reposicion_gondola(id);
        System.out.println("acavoy");
        Response response= reposicionGondolaServicio.editar(reposicionGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
