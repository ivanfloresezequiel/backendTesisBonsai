package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;

@Entity
@Table(name="marca")
public class Marca {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_marca;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private Boolean estado;

    public Marca(){

    }

    public Marca(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}






