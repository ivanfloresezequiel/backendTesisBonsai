package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;


@Entity
@Table(name="presentacion")
public class Presentacion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_presentacion;
    @Column
    private String nombre;
    @Column
    private String etiqueta;
    @Column
    private boolean estado;

    public Presentacion(String nombre, String etiqueta, boolean estado) {
        this.nombre = nombre;
        this.etiqueta = etiqueta;
        this.estado = estado;
    }

    public Presentacion() {
    }

    public int getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(int id_presentacion) {
        this.id_presentacion = id_presentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
