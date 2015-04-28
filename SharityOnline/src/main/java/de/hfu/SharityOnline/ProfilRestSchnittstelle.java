package de.hfu.SharityOnline;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/profil")
@Produces(MediaType.APPLICATION_JSON)
public class ProfilRestSchnittstelle extends Application {

//  private final String jsonErrorMsg = "{Error: \"x\"";
//  private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Profil> repository = new Repository<Profil>();

  @GET
  @Path("")
  public Response loadEntity() {
    List<Profil> allProfiles = repository.loadAll(Profil.class);
    return Response.status(200).entity(allProfiles).type(MediaType.APPLICATION_JSON).build();
  }
  
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    Profil profil = repository.loadById(Profil.class, id);
    return Response.status(200).entity(profil).type(MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Path("/create")
  public Response createEntity(Profil profil) {
    if (profil != null) {
      profil.setId(UUID.randomUUID().toString());
      repository.save(profil);
      return Response.status(200).entity(profil.getId()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PUT
  @Path("/update")
  public Response updateEntity(Profil profil) {
    if (profil.getId() != null) {
      repository.save(profil);
      return Response.status(200).entity(profil.getId()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

}
