package com.bonsaiBackend.bonsaiBackend.Security.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Security.Enums.RolNombre;
import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);

}
