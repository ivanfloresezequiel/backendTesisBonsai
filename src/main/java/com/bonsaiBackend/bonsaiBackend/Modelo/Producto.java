package com.bonsaiBackend.bonsaiBackend.Modelo;

import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Rol;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;
    @Column
    private int codigoBarra;
    @Column
    private Date fechaBaja;
    @Column
    private String presentacion;
    @Column
    private String productoDescripcion;
    @Column
    private String productoInformacion;
    @Column
    private String nombre;
    @Column
    private int stockActual;
    @Column
    private int stockMinimo;
    @Column
    private Boolean estado;
    @NotNull
    @ManyToMany ()
    @JoinTable (name = "producto_proveedor", joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn (name = "id_proveedor"))
    private Set<Proveedor> proveedores = new HashSet<>();
    @ManyToOne
    @JoinColumn (name = "categoria_id")
    private Categoria categoriaID;
    @ManyToOne
    @JoinColumn (name = "marca_id")
    private Marca marcaID;
    @ManyToOne
    @JoinColumn (name = "presentacion_id")
    private Presentacion presentacionID;


    public Producto(int codigoBarra, Date fechaBaja,
                    String presentacion, String productoDescripcion, String productoInformacion,
                    String nombre, int stockActual, int stockMinimo, Boolean estado,
                    Categoria categoriaID, Marca marcaID, Presentacion presentacionID){

        codigoBarra = this.codigoBarra;
        fechaBaja = this.fechaBaja;

        presentacion = this.presentacion;
        productoDescripcion = this.productoDescripcion;
        productoInformacion = this.productoInformacion;
        nombre = this.nombre;
        stockActual = this.stockActual;
        stockMinimo = this.stockMinimo;
        estado = this.estado;
        categoriaID = this.categoriaID;
        marcaID = this.marcaID;
        presentacionID = this.presentacionID;
    }

    public Producto(){}
    public void setId_producto (int id_producto){
        this.id_producto = id_producto;
    }
    public void setCodigoBarra(int codigoBarra){

        this.codigoBarra = codigoBarra;
    }
    public void setFechaBaja (Date fechaBaja){

        this.fechaBaja = fechaBaja;
    }

    public void setPresentacion (String presentacion){

        this.presentacion = presentacion;
    }

    public Presentacion getPresentacionID() {
        return presentacionID;
    }

    public void setPresentacionID(Presentacion presentacionID) {
        this.presentacionID = presentacionID;
    }

    public void setProductoDescripcion (String productoDescripcion){

        this.productoDescripcion = productoDescripcion;
    }
    public void setProductoInformacion (String productoInformacion){

        this.productoInformacion = productoInformacion;
    }
    public void setNombre (String nombre){

        this.nombre = nombre;
    }

    public Set<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Set<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setCategoriaID(Categoria categoriaID) {

        this.categoriaID = categoriaID;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Marca getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(Marca marcaID) {
        this.marcaID = marcaID;
    }

    public void setStockActual (int stockActual){

        this.stockActual = stockActual;
    }
    public void setStockMinimo (int stockMinimo){

        this.stockMinimo = stockMinimo;
    }

    public int getId_producto (){
        return id_producto;
    }
    public int getCodigoBarra (){
        return codigoBarra;
    }
    public int getStockActual(){
        return stockActual;
    }
    public int getStockMinimo(){
        return stockMinimo;
    }
    public Categoria getCategoriaID(){
        return categoriaID;
    }
    public String getPresentacion(){
        return presentacion;
    }
    public String getProductoDescripcion(){
        return productoDescripcion;
    }
    public String getProductoInformacion(){
        return productoInformacion;
    }
    public String getNombre(){
        return nombre;
    }
    public Date getFechaBaja(){
        return fechaBaja;
    }



}
