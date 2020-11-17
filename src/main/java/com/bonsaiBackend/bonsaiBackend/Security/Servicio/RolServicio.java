package com.bonsaiBackend.bonsaiBackend.Security.Servicio;

import com.bonsaiBackend.bonsaiBackend.Security.Enums.RolNombre;
import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Rol;
import com.bonsaiBackend.bonsaiBackend.Security.Repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){

        return rolRepositorio.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepositorio.save(rol);
    }
}
