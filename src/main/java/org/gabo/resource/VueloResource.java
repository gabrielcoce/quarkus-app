package org.gabo.resource;


import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.gabo.dto.CreateFlyDto;
import org.gabo.dto.UpdateFlyDto;
import org.gabo.model.Vuelos;
import org.gabo.service.VuelosService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VueloResource {
    @Inject
    VuelosService services;
    Logger logger = Logger.getLogger(VueloResource.class.getName());
    @GET
    @Path("vuelos")
    public Response all(){
        List<Vuelos> vuelos = services.allVuelos();
        return Response.ok(vuelos).build();
    }

    @GET
    @Path("vuelos/{idVuelo}")
    public Response findVuelo(@PathParam("idVuelo") Long idVuelo){
        return Response.ok(services.findByIdVuelo(idVuelo)).build();
    }

    @POST
    @Path("vuelos/crear-vuelo")
    public Response createFly(@RequestBody CreateFlyDto vuelo){
        logger.info("vuelos nuevo " + vuelo);
        return Response.ok(services.createVuelo(vuelo)).build();
    }

    @PUT
    @Path("vuelos/actualizar-vuelo")
    public Response updateFly(@RequestBody UpdateFlyDto vuelo) {
        return Response.ok(services.updateVuelo(vuelo)).build();
    }

    @DELETE
    @Path("vuelos/eliminar-vuelo/{idVuelo}")
    public Response deleteFly(@PathParam("idVuelo") Long idVuelo){
        return Response.ok(services.deleteVuelo(idVuelo)).build();
    }
}
