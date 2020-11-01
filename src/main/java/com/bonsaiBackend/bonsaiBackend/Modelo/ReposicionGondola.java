package com.bonsaiBackend.bonsaiBackend.Modelo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="reposicion_gondola")

public class ReposicionGondola {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reposicion_gondola;
    @Column
    private int capacidadMax;
    @Column
    private int capacidadMin;
    @Column
    private String tipo_presentacion;

    public ReposicionGondola(int capacidadMax, int capacidadMin, String tipo_presentacion){
        capacidadMax = this.capacidadMax;
        capacidadMin = this.capacidadMin;
        tipo_presentacion = this.tipo_presentacion;
    }

    public ReposicionGondola(){}

    public void setId_reposicion_gondola(int id_reposicion_gondola){
        this.id_reposicion_gondola = id_reposicion_gondola;
    }

    public void setCapacidadMax (int capacidadMax){
        this.capacidadMax = capacidadMax;
    }
    public void setCapacidadMin (int capacidadMin){
        this.capacidadMin = capacidadMin;
    }
    public void setTipo_presentacion(String tipo_presentacion){
        this.tipo_presentacion = tipo_presentacion;
    }

    public int getId_reposicion_gondola (){
        return id_reposicion_gondola;
    }
    public int getCapacidadMax(){
        return capacidadMax;
    }

    public int getCapacidadMin() {
        return capacidadMin;
    }
    public String getTipo_presentacion(){
        return tipo_presentacion;
    }
}
