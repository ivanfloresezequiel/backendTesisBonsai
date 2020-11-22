package com.bonsaiBackend.bonsaiBackend.DTO;

import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;

public class cuentaBancariaDTO {
    private int id_cuentaBancaria;
    private String cbu;
    private String tipoCuenta;
    private boolean estado;
    private int idBanco;
    private int idProveedor;





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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
