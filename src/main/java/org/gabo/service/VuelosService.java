package org.gabo.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.gabo.dto.CreateFlyDto;
import org.gabo.dto.UpdateFlyDto;
import org.gabo.entity.VuelosEntity;
import org.gabo.model.Vuelos;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class VuelosService {
    Logger logger = Logger.getLogger(VuelosService.class.getName());
    public List<Vuelos> allVuelos(){
        List<VuelosEntity> vuelos = VuelosEntity.findAll().list();
        //logger.info("vuelos " + vuelos);

        return vuelos.stream().map(fly -> {
            return new Vuelos(fly.id, fly.numeroPasaporte, fly.aeropuertoEntrada, fly.aeropuertoSalida, fly.fechaHoraEntrada, fly.fechaHoraSalida);
        }).collect(Collectors.toList());
    }

    public VuelosEntity findByIdVuelo(Long idVuelo){
        logger.info("vuelos id " + VuelosEntity.findByIdOptional(idVuelo));
        Optional<VuelosEntity> vuelos =  VuelosEntity.findByIdOptional(idVuelo);
        if(vuelos.isEmpty()){
            throw new NotFoundException("No se encontró el vuelo");
        }

       return vuelos.get();
    }

    @Transactional
    public VuelosEntity createVuelo(CreateFlyDto vuelo){
        //logger.info("vuelos nuevo " + vuelo);
        VuelosEntity entity = new VuelosEntity();
        entity.numeroPasaporte = vuelo.getNumeroPasaporte();
        entity.aeropuertoEntrada = vuelo.getAeropuertoEntrada();
        entity.aeropuertoSalida = vuelo.getAeropuertoSalida();
        entity.fechaHoraEntrada = vuelo.getFechaHoraEntrada();
        entity.fechaHoraSalida = vuelo.getFechaHoraSalida();
        entity.persist();
        return entity;
    }

    @Transactional
    public VuelosEntity updateVuelo(UpdateFlyDto vuelo){
        VuelosEntity entity = VuelosEntity.findById(vuelo.getId());
        logger.info("vuelo a actualizar " + entity);
        if(entity == null){
            logger.info("No se pudo actualizar vuelo ");
            throw new NotFoundException("No se pudo actualizar vuelo");
        }
        entity.aeropuertoEntrada = vuelo.getAeropuertoEntrada();
        entity.aeropuertoSalida = vuelo.getAeropuertoSalida();
        entity.fechaHoraEntrada = vuelo.getFechaHoraEntrada();
        entity.fechaHoraSalida = vuelo.getFechaHoraSalida();
        return entity;
    }

    @Transactional
    public Boolean deleteVuelo(Long id){
        VuelosEntity entity = VuelosEntity.findById(id);
        if(entity == null){
            return false;
        }
        return VuelosEntity.deleteById(id);
    }
}
