package org.gabo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateFlyDto {
    private Long id;
    private String aeropuertoEntrada;
    private String aeropuertoSalida;
    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;

    public UpdateFlyDto() {
    }

    public UpdateFlyDto(Long id, String aeropuertoEntrada, String aeropuertoSalida, Date fechaHoraEntrada, Date fechaHoraSalida) {
        this.id = id;
        this.aeropuertoEntrada = aeropuertoEntrada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
    }
}
