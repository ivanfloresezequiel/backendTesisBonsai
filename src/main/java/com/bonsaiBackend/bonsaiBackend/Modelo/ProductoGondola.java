package com.bonsaiBackend.bonsaiBackend.Modelo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="producto_gondola")

public class ProductoGondola {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto_gondola;
    @Column
    private String nivel_ventas;
    @ManyToOne
    @JoinColumn (name = "gondola_id")
    private Gondola  gondolaID;
    @ManyToOne
    @JoinColumn (name = "producto_id")
    private Producto productoID;

    public ProductoGondola(String nivel_ventas, Gondola gondolaID, Producto productoID){
        nivel_ventas = this.nivel_ventas;
        gondolaID = this.gondolaID;
        productoID = this.productoID;
    }

    public ProductoGondola(){}

    public void setGondolaID(Gondola gondolaID) {
        this.gondolaID = gondolaID;
    }

    public void setId_producto_gondola(int id_producto_gondola) {
        this.id_producto_gondola = id_producto_gondola;
    }

    public void setNivel_ventas(String nivel_ventas) {
        this.nivel_ventas = nivel_ventas;
    }

    public void setProductoID(Producto productoID) {
        this.productoID = productoID;
    }

    public int getId_producto_gondola() {
        return id_producto_gondola;
    }

    public String getNivel_ventas() {
        return nivel_ventas;
    }

    public Producto getProductoID() {
        return productoID;
    }

    public Gondola getGondolaID() {
        return gondolaID;
    }
}
