package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "prueba")
public class Prueba {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prueba;
    @Column
    private String nombre;
    @ManyToOne
    @JoinColumn (name = "categoria_id")
    private Categoria categoriaID;

    public Prueba(String nombre, Categoria categoriaID) {

        this.nombre = nombre;
        this.categoriaID = categoriaID;
    }

    public Prueba() {
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Categoria categoriaID) {
        this.categoriaID = categoriaID;
    }
}
