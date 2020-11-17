package com.bonsaiBackend.bonsaiBackend.Security.Repositorio;

import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    //boolean existByNombreUsuario(String nombreUsuario);
    //boolean existByMail(String mail);
}
