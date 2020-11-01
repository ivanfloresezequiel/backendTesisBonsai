package com.bonsaiBackend.bonsaiBackend.Modelo;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tipo_gondola")
public class TipoGondola {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_gondola;
    @Column
    private String descripcion;

    public TipoGondola(String descripcion){
        descripcion = this.descripcion;
    }
    public TipoGondola(){}

    public void setId_tipo_gondola(int id_tipo_gondola) {
        this.id_tipo_gondola = id_tipo_gondola;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tipo_gondola(){
        return id_tipo_gondola;
    }
    public String getDescripcion (){
        return descripcion;
    }
}
