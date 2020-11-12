package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cuenta_bancaria")

public class CuentaBancaria {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuentaBancaria;
    @Column
    private String CBU;
    @Column
    private String tipoCuenta;
    @Column
    private boolean estado;
    @ManyToOne
    @JoinColumn (name = "banco_id")
    private Banco bancoID;

    public CuentaBancaria(String CBU, String tipoCuenta, boolean estado, Banco bancoID) {
        this.CBU = CBU;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
        this.bancoID = bancoID;
    }

    public CuentaBancaria() {
    }

    public int getId_cuentaBancaria() {
        return id_cuentaBancaria;
    }

    public void setId_cuentaBancaria(int id_cuentaBancaria) {
        this.id_cuentaBancaria = id_cuentaBancaria;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
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
