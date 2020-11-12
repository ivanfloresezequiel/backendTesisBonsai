package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;
import com.bonsaiBackend.bonsaiBackend.Servicio.BancoServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping({"/bancos"})


public class BancoControlador {
    @Autowired
    BancoServicio bancoServicio;

    @GetMapping("/habilitados")
    public ResponseEntity<Response> listarHabilitados()  {
        Response response = bancoServicio.ListarHabilitados();
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = bancoServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Banco banco) throws Exception {
        Response response = bancoServicio.guardarBanco(banco);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = bancoServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Banco banco, @PathVariable("id")Integer id){
        banco.setId_banco(id);
        //System.out.println("acavoy");
        Response response= bancoServicio.editar(banco);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*@PutMapping
    public ResponseEntity<Response> actualizar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.actualizarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}
