package com.bonsaiBackend.bonsaiBackend.Security.Servicio;

import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Usuario;
import com.bonsaiBackend.bonsaiBackend.Security.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional

public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
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
