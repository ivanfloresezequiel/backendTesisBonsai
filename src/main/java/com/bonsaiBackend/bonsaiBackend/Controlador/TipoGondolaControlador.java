package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.TipoGondola;


import com.bonsaiBackend.bonsaiBackend.Servicio.TipoGondolaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping({"/tipo_gondolas"})

public class TipoGondolaControlador {
    @Autowired
    TipoGondolaServicio tipoGondolaServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = tipoGondolaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody TipoGondola tipoGondola) throws Exception {
        Response response = tipoGondolaServicio.guardarTipoGondola(tipoGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = tipoGondolaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody TipoGondola tipoGondola, @PathVariable("id")Integer id){
        tipoGondola.setId_tipo_gondola(id);
       // System.out.println("acavoy");
        Response response= tipoGondolaServicio.editar(tipoGondola);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
