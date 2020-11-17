package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;

import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;

import com.bonsaiBackend.bonsaiBackend.Servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping({"/proveedores"})

public class ProveedorControlador  {
    @Autowired
    ProveedorServicio proveedorServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = proveedorServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
@GetMapping("/habilitados")
public ResponseEntity<Response> listarHabilitados(){
    Response response = proveedorServicio.buscarHabilitados();
    return new ResponseEntity<>(response, HttpStatus.OK);
}
    @PostMapping
    public ResponseEntity<Response> guardarProveedor(@RequestBody Proveedor proveedor) throws Exception {
        Response response = proveedorServicio.guardarProveedor(proveedor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Response response = proveedorServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Proveedor proveedor, @PathVariable("id") int id){
        proveedor.setId_proveedor(id);
        //System.out.println("acavoy");
        Response response= proveedorServicio.editar(proveedor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
