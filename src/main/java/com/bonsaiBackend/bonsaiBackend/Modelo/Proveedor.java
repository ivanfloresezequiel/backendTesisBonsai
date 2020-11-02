package com.bonsaiBackend.bonsaiBackend.Modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="proveedor")

public class Proveedor {

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
    private int cuit;
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


    public Proveedor(int cuit, String direccion, String mail, String nombre,
                     String razon_social, String telefono_fijo,
                     String whatsapp){
            cuit = this.cuit;
            direccion = this.direccion;
            mail = this.mail;
            nombre = this.nombre;
            razon_social = this.razon_social;
            telefono_fijo = this.telefono_fijo;
            whatsapp = this.whatsapp;
    }

    public Proveedor(){}

    public void setCuit(int cuit) {
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

    public int getCuit() {
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
