package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;

@Entity
@Table(name="categoria")

public class Categoria {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    @Column
    private String descripcion;
    @Column
    private String etiqueta;


    public Categoria (String descripcion, String etiqueta){

        descripcion = this.descripcion;
        etiqueta = this.etiqueta;
    }

    public Categoria(){

    }

    public void setDescripcion (String descripcion){
            this.descripcion = descripcion;
    }

    public void setEtiqueta (String etiqueta){
        this.etiqueta = etiqueta;
    }

    public int getId_categoria(){
        return id_categoria;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getEtiqueta(){
        return etiqueta;
    }
}