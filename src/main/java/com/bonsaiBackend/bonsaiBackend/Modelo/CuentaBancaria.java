package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="cuenta_bancaria")

public class CuentaBancaria {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuentaBancaria;
    @Column
    private String cbu;
    @Column
    private String tipoCuenta;
    @Column
    private boolean estado;
    @ManyToOne
    @JoinColumn (name = "id_banco")
    private Banco bancoID;
    @ManyToOne
    @JoinColumn (name = "id_proveedor")
    private Proveedor proveedorID;

    public CuentaBancaria(String cbu, String tipoCuenta, boolean estado, Banco bancoID, Proveedor proveedorID) {
        this.cbu = cbu;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
        this.bancoID = bancoID;
        this.proveedorID = proveedorID;
    }

    public CuentaBancaria() {
    }

    public int getId_cuentaBancaria() {
        return id_cuentaBancaria;
    }

    public void setId_cuentaBancaria(int id_cuentaBancaria) {
        this.id_cuentaBancaria = id_cuentaBancaria;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public Proveedor getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(Proveedor proveedorID) {
        this.proveedorID = proveedorID;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Banco getBancoID() {
        return bancoID;
    }

    public void setBancoID(Banco bancoID) {
        this.bancoID = bancoID;
    }
}
