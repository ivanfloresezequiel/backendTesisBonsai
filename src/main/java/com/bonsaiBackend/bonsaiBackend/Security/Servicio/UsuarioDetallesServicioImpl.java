package com.bonsaiBackend.bonsaiBackend.Security.Servicio;

import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Usuario;
import com.bonsaiBackend.bonsaiBackend.Security.Modelo.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UsuarioDetallesServicioImpl implements UserDetailsService {

    @Autowired
    UsuarioServicio usuarioServicio;


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
