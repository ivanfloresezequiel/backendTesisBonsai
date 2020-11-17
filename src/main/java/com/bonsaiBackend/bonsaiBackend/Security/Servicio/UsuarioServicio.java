package com.bonsaiBackend.bonsaiBackend.Security.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Usuario;
import com.bonsaiBackend.bonsaiBackend.Security.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        response.setData(usuario);
        return response;
    }

    public Response listar() throws Exception {
        Response response = new Response();
        List<Usuario> usuario = usuarioRepositorio.findAll();
        if (usuario == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Usuarios");
        response.setData(usuario);
        return response;
    }

    /*public boolean existsByNombreUsuario (String nombreUsuario){
        return usuarioRepositorio.existByNombreUsuario(nombreUsuario);
    }


    public boolean existsByMail (String mail){
        return usuarioRepositorio.existByMail(mail);
    }*/

    public void save(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

}
