package com.bonsaiBackend.bonsaiBackend.Modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="proveedor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proveedor implements Serializable {

    /*DIRECCION	varchar(200)
    MAIL	varchar(100)
    NOMBRE	varchar(100)
    RAZON_SOCIAL	varchar(200)
    TELEFONO_FIJO	decimal(10,0)
    WHATSAPP	decimal(10,0)
    * */

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;
    @Column
    private double cuit;
    @Column
    private String direccion;
    @Column
    private String mail;
    @Column
    private String nombre;
    @Column
    private String razon_social;
    @Column
    private String telefono_fijo;
    @Column
    private String whatsapp;
    @Column
    private Boolean estado;


    public Proveedor(double cuit, String direccion, String mail, String nombre,
                     String razon_social, String telefono_fijo,
                     String whatsapp){
            cuit = this.cuit;
            direccion = this.direccion;
            mail = this.mail;
            nombre = this.nombre;
            razon_social = this.razon_social;
            telefono_fijo = this.telefono_fijo;
            whatsapp = this.whatsapp;
            estado = true;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Proveedor(){}

    public void setCuit(double cuit) {
        this.cuit = cuit;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public double getCuit() {
        return cuit;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

}
