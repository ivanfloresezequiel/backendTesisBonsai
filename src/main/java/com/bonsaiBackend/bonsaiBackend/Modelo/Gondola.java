package com.bonsaiBackend.bonsaiBackend.Modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="gondola")

public class Gondola {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_gondola;
    @Column
    private int capacidadMax;
    @Column
    @JoinColumn(name = "capacidad_min")
    private int capacidadMIn;
    @Column
    private String ubicacion;
    @ManyToOne
    @JoinColumn (name = "tipo_gondola_id")
    private TipoGondola tipoGondolaID;
    @ManyToOne
    @JoinColumn (name = "reposicion_id")
    private ReposicionGondola reposicionGondolaID;

    public Gondola (int capacidadMax, int capacidadMin,String ubicacion, TipoGondola tipoGondolaID,
                    ReposicionGondola reposicionGondolaID ){
        capacidadMax = this.capacidadMax;
        capacidadMin = this.capacidadMIn;
        ubicacion = this.ubicacion;
        tipoGondolaID = this.tipoGondolaID;
        reposicionGondolaID = this.reposicionGondolaID;

    }

    public Gondola(){}

    public void setId_gondola(int id_gondola){
            this.id_gondola = id_gondola;
    }

    public void setCapacidadMax(int capacidadMax){
        this.capacidadMax = capacidadMax;
    }

    public void setCapacidadMIn(int capacidadMIn) {
        this.capacidadMIn = capacidadMIn;
    }

    public void setReposicionGondolaID(ReposicionGondola reposicionGondolaID) {
        this.reposicionGondolaID = reposicionGondolaID;
    }

    public void setTipoGondolaID(TipoGondola tipoGondolaID) {
        this.tipoGondolaID = tipoGondolaID;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public int getCapacidadMIn() {
        return capacidadMIn;
    }

    public int getId_gondola() {
        return id_gondola;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public TipoGondola getTipoGondolaID() {
        return tipoGondolaID;
    }

    public ReposicionGondola getReposicionGondolaID() {
        return reposicionGondolaID;
    }
}
