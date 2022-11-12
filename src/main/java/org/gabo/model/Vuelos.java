package org.gabo.model;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import java.util.Date;
@Getter
@Setter
public class Vuelos {
    private Long id;
    private String numeroPasaporte;
    private String aeropuertoEntrada;
    private String aeropuertoSalida;
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss Z")
    private Date fechaHoraEntrada;
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss Z")
    private Date fechaHoraSalida;

    public Vuelos() {
    }

    public Vuelos(Long id, String numeroPasaporte, String aeropuertoEntrada, String aeropuertoSalida, Date fechaHoraEntrada, Date fechaHoraSalida) {
        this.id = id;
        this.numeroPasaporte = numeroPasaporte;
        this.aeropuertoEntrada = aeropuertoEntrada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
    }
}
