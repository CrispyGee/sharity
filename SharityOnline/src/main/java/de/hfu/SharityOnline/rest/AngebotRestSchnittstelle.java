package de.hfu.SharityOnline.rest;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.setup.Repository;

@Path("/angebot")
@Produces(MediaType.APPLICATION_JSON)
public class AngebotRestSchnittstelle {

  // private final String jsonErrorMsg = "{Error: \"x\"";
  // private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Offer> repository = new Repository<Offer>();

  @PermitAll
  @GET
  @Path("")
  public Response loadEntity() {
    List<Offer> alleAngebote = repository.loadAll(Offer.class);
    return Response.status(200).entity(alleAngebote).type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    Offer offer = repository.loadById(Offer.class, id);
    return Response.status(200).entity(offer).type(MediaType.APPLICATION_JSON).build();
  }

  @RolesAllowed({ "ADMIN", "VERIFIEDUSER" })
  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("/new")
  public Response createEntity(Offer offer) {
    if (offer != null && angebotAnforderung(offer)) {
      offer.setOffer_id(UUID.randomUUID().toString());
      repository.save(offer);
      return Response.status(200).entity(offer.getOffer_id()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @RolesAllowed({ "ADMIN", "VERIFIEDUSER" })
  @Consumes(MediaType.APPLICATION_JSON)
  @PUT
  @Path("/update")
  public Response updateEntity(Offer offer) {
    if (offer.getOffer_id() != null && angebotAnforderung(offer)) {
      repository.save(offer);
      return Response.status(200).entity(offer.getOffer_id()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @RolesAllowed({ "ADMIN", "VERIFIEDUSER" })
  @Consumes(MediaType.APPLICATION_JSON)
  @GET
  @Path("/delete/{id}")
  public Response deleteEntity(@PathParam("id") String id) {
    if (repository.deleteByID(Offer.class, id)) {
      return Response.status(200).build();
    } else {
      return Response.status(204).build();
    }

  }

  public boolean angebotAnforderung(Offer offer) {
    return true;
    // if(angebot.gETBESCHREIBUNG() != NULL &&
    // ANGEBOT.GETBEZEICHNUNG() != NULL &&
    // ANGEBOT.GETKATEGORIE() != NULL) {
    // RETURN TRUE;
    // } ELSE {
    // RETURN FALSE;
    // }
  }

}
