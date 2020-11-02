package com.bonsaiBackend.bonsaiBackend.Modelo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="producto_proveedor")

public class ProductoProveedor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto_proveedor;
    @ManyToOne
    @JoinColumn (name = "proveedor_id")
    private Proveedor proveedorID;
    @ManyToOne
    @JoinColumn (name = "producto_id_produ_prove")
    private Producto productoID;

    public ProductoProveedor (Proveedor proveedorID, Producto productoID){
        proveedorID = this.proveedorID;
        productoID = this.productoID;
    }

    public ProductoProveedor(){}

    public void setProductoID(Producto productoID) {
        this.productoID = productoID;
    }

    public void setId_producto_proveedor(int id_producto_proveedor) {
        this.id_producto_proveedor = id_producto_proveedor;
    }

    public void setProveedorID(Proveedor proveedorID) {
        this.proveedorID = proveedorID;
    }

    public int getId_producto_proveedor() {
        return id_producto_proveedor;
    }

    public Proveedor getProveedorID() {
        return proveedorID;
    }

    public Producto getProductoID() {
        return productoID;
    }
}
