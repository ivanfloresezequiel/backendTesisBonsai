package com.bonsaiBackend.bonsaiBackend.Controlador;


import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Marca;
import com.bonsaiBackend.bonsaiBackend.Servicio.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping({"/marcas"})
public class MarcaControlador {

    @Autowired
    MarcaServicio marcaServicio;

    @GetMapping("/habilitados")
    public ResponseEntity<Response> listarHabilitados()  {
        Response response = marcaServicio.ListarHabilitados();
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<Response> listar() throws Exception {
        Response response = null;
        try {
            response = marcaServicio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Marca marca) throws Exception {
        Response response = marcaServicio.guardarCategoria(marca);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> listarPorId(@PathVariable("id") Integer id) throws Exception {

        Response response = marcaServicio.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Response>Editar(@RequestBody Marca marca, @PathVariable("id")Integer id){
        marca.setId_marca(id);
        System.out.println("acavoy");
        Response response= marcaServicio.editar(marca);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*@PutMapping
    public ResponseEntity<Response> actualizar(@RequestBody Categoria categoria) throws Exception {
        Response response = categoriaServicio.actualizarCategoria(categoria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}
