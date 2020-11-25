package com.bonsaiBackend.bonsaiBackend.DTO;

import java.util.Date;

public class ProductoDTO {
  private  int id_producto;
   private int codigoBarra;
  private Date fechaBaja;
    private String presentacion;
    private String productoDescripcion;
    private String productoInformacion;
    private String nombre;
    private  int stockActual;
    private  int stockMinimo;
    private boolean estado;
    private  int categoriaID;
    private  int marcaID;
    private  int   presentacionID;
    private int proveedoresID[];

    public int[] getProveedoresID() {
        return proveedoresID;
    }

    public void setProveedoresID(int[] proveedoresID) {
        this.proveedoresID = proveedoresID;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public String getProductoInformacion() {
        return productoInformacion;
    }

    public void setProductoInformacion(String productoInformacion) {
        this.productoInformacion = productoInformacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(int marcaID) {
        this.marcaID = marcaID;
    }

    public int getPresentacionID() {
        return presentacionID;
    }

    public void setPresentacionID(int presentacionID) {
        this.presentacionID = presentacionID;
    }
}

