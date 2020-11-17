package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.DTO.cuentaBancariaDTO;
import com.bonsaiBackend.bonsaiBackend.Modelo.CuentaBancaria;
import com.bonsaiBackend.bonsaiBackend.Servicio.BancoServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.CategoriaServicio;
import com.bonsaiBackend.bonsaiBackend.Servicio.CuentaBancariaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping({"/cuentas_bancarias"})
public class CuentaBancariaControlador {
    @Autowired
    CuentaBancariaServicio cuentaBancariaServicio;
    @Autowired
    BancoServicio bancoServicio;

    @GetMapping("/habilitados")
    public ResponseEntity<Response> listarHabilitados()  {
        Response response = cuentaBancariaServicio.ListarHabilitados();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {

        Response response = null;
        try {
            response = cuentaBancariaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody CuentaBancaria cuentaBancaria) throws Exception {
        System.out.println("entreaGuardar");

        Response response = cuentaBancariaServicio.guardarCuentaBancaria(cuentaBancaria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = cuentaBancariaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody CuentaBancaria cuentaBancaria, @PathVariable("id")Integer id){
        cuentaBancaria.setId_cuentaBancaria(id);
        //System.out.println("acavoy");
        Response response= cuentaBancariaServicio.editar(cuentaBancaria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*@PutMapping
    public ResponseEntity<Response> actualizar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.actualizarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
}
