package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;

@Entity
@Table(name="productos_prueba")
public class ProductoPrueba {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productos_id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String informacion;

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInformacion() {
        return informacion;
    }
}
