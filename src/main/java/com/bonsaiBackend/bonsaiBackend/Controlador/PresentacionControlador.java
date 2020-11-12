package com.bonsaiBackend.bonsaiBackend.Controlador;


import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Presentacion;

import com.bonsaiBackend.bonsaiBackend.Servicio.PresentacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping({"/presentaciones"})

public class PresentacionControlador {

    @Autowired
    PresentacionServicio presentacionServicio;

    @GetMapping("/habilitados")
    public ResponseEntity<Response> listarHabilitados()  {
        Response response = presentacionServicio.ListarHabilitados();
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = presentacionServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Presentacion presentacion) throws Exception {
        Response response = presentacionServicio.guardarPresentacion(presentacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = presentacionServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Presentacion presentacion, @PathVariable("id")Integer id){
        presentacion.setId_presentacion(id);
       // System.out.println("acavoy");
        Response response= presentacionServicio.editar(presentacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*@PutMapping
    public ResponseEntity<Response> actualizar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.actualizarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}
