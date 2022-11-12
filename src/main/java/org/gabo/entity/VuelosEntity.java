package org.gabo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vuelos", schema = "vuelos")
public class VuelosEntity extends PanacheEntity {

    @Column(name="numero_pasaporte")
    public String numeroPasaporte;

    @Column(name="aeropuerto_entrada")
    public String aeropuertoEntrada;

    @Column(name="aeropuerto_salida")
    public String aeropuertoSalida;
    //@JsonbDateFormat(value = "yyyy-MM-dd")
    @Column(name="fecha_hora_entrada")
    public Date fechaHoraEntrada;
    //@JsonbDateFormat(value = "yyyy-MM-dd")
    @Column(name="fecha_hora_salida")
    public Date fechaHoraSalida;

}
