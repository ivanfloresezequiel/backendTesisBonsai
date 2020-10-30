package com.bonsaiBackend.bonsaiBackend.Modelo;
import javax.persistence.*;
import java.util.Date;

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
    private Date fechaLimiteVencimiento;
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
    private Date fechaVencimiento;
    @Column
    private int categoriaID;

    public Producto (int codigoBarra, Date fechaBaja, Date fechaLimiteVencimiento,
                     String presentacion, String productoDescripcion, String productoInformacion,
                     String nombre, int stockActual, int stockMinimo, Date fechaVencimiento,
                     int categoriaID){
        codigoBarra = this.codigoBarra;
        fechaBaja = this.fechaBaja;
        fechaLimiteVencimiento = this.fechaLimiteVencimiento;
        presentacion = this.presentacion;
        productoDescripcion = this.productoDescripcion;
        productoInformacion = this.productoInformacion;
        nombre = this.nombre;
        stockActual = this.stockActual;
        stockMinimo = this.stockMinimo;
        fechaVencimiento = this.fechaVencimiento;
        categoriaID = this.categoriaID;
    }

    public Producto(){}

    public void setCodigoBarra(int codigoBarra){
        this.codigoBarra = codigoBarra;
    }
    public void setFechaBaja (Date fechaBaja){
        this.fechaBaja = fechaBaja;
    }
    public void setFechaLimiteVencimiento (Date fechaLimiteVencimiento){
        this.fechaLimiteVencimiento = fechaLimiteVencimiento;
    }
    public void setPresentacion (String presentacion){
        this.presentacion = presentacion;
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

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public void setStockActual (int stockActual){
        this.stockActual = stockActual;
    }
    public void setStockMinimo (int stockMinimo){
        this.stockMinimo = stockMinimo;
    }
    public void setFechaVencimiento (Date fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
    public int getId_producto (){return id_producto;}
    public int getCodigoBarra (){return codigoBarra;}
    public int getStockActual(){return stockActual;}
    public int getStockMinimo(){return stockMinimo;}
    public int getCategoriaID(){return categoriaID;}
    public String getPresentacion(){return presentacion;}
    public String getProductoDescripcion(){return productoDescripcion;}
    public String getProductoInformacion(){return productoInformacion;}
    public String getNombre(){return nombre;}
    public Date getFechaBaja(){return fechaBaja;}
    public Date getFechaLimiteVencimiento(){return fechaLimiteVencimiento;}
    public Date getFechaVencimiento(){return fechaVencimiento;}


}
