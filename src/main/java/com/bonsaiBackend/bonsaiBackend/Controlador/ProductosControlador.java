package com.bonsaiBackend.bonsaiBackend.Controlador;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping({"/productos"})
public class ProductosControlador {
    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = productoServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
