package com.bonsaiBackend.bonsaiBackend.DTO;

import com.bonsaiBackend.bonsaiBackend.Modelo.Banco;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;

public class cuentaBancariaDTO {
    private int id_cuentaBancaria;
    private String cbu;
    private String tipoCuenta;
    private boolean estado;
    private Banco idBanco;
    private Proveedor idProveedor;

    public cuentaBancariaDTO( String cbu, String tipoCuenta, boolean estado, Banco idBanco, Proveedor idProveedor) {

        this.cbu = cbu;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
        this.idBanco = idBanco;
        this.idProveedor = idProveedor;
    }

    public cuentaBancariaDTO() {
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }
}
