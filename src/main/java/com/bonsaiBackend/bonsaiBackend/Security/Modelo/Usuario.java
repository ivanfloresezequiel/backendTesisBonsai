package com.bonsaiBackend.bonsaiBackend.Security.Modelo;

import com.sun.istack.NotNull;
import org.hibernate.dialect.HANAColumnStoreDialect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ID_USUARIO;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String mail;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "ID_USUARIO"),
    inverseJoinColumns = @JoinColumn (name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {

    }

    public Usuario(String nombre, String nombreUsuario, String mail, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return ID_USUARIO;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.ID_USUARIO = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
