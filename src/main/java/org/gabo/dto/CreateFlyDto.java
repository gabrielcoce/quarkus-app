package org.gabo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateFlyDto {
    private String numeroPasaporte;
    private String aeropuertoEntrada;
    private String aeropuertoSalida;
    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;

    public CreateFlyDto() {
    }

    public CreateFlyDto(String numeroPasaporte, String aeropuertoEntrada, String aeropuertoSalida, Date fechaHoraEntrada, Date fechaHoraSalida) {
        this.numeroPasaporte = numeroPasaporte;
        this.aeropuertoEntrada = aeropuertoEntrada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public String toString() {
        return "CreateFlyDto{" +
                "numeroPasaporte='" + numeroPasaporte + '\'' +
                ", aeropuertoEntrada='" + aeropuertoEntrada + '\'' +
                ", aeropuertoSalida='" + aeropuertoSalida + '\'' +
                ", fechaHoraEntrada=" + fechaHoraEntrada +
                ", fechaHoraSalida=" + fechaHoraSalida +
                '}';
    }
}
