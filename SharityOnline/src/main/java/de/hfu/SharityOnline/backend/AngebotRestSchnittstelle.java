package de.hfu.SharityOnline.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hfu.SharityOnline.frontend.ProfilFrontend;

@Path("/angebot")
@Produces(MediaType.APPLICATION_JSON)
public class AngebotRestSchnittstelle {

  // private final String jsonErrorMsg = "{Error: \"x\"";
  // private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Angebot> repository = new Repository<Angebot>();
  private static final ModelMapper MAPPER = new ModelMapper();

  @GET
  @Path("")
  public Response loadEntity() {
    List<Angebot> alleAngebote = repository.loadAll(Angebot.class);
    return Response.status(200).entity(alleAngebote).type(MediaType.APPLICATION_JSON).build();
  }

  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    Angebot angebot = repository.loadById(Angebot.class, id);
    return Response.status(200).entity(angebot).type(MediaType.APPLICATION_JSON).build();
  }
  
  @GET
  @Path("/{detail}")
  public Response loadEntityDetail() {
    List<Angebot> alleAngebote = repository.loadWithLimit(30, Angebot.class);
    List<KomprimiertesAngebot> alleAngeboteKomprimiert = new ArrayList<KomprimiertesAngebot>();
    for (Angebot angebot : alleAngebote) {
      alleAngeboteKomprimiert.add(MAPPER.map(angebot, KomprimiertesAngebot.class)); 
    }
    return Response.status(200).entity(alleAngeboteKomprimiert).type(MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Path("/create")
  public Response createEntity(Angebot angebot) {
    if (angebot != null) {
      angebot.setId(UUID.randomUUID().toString());
      repository.save(angebot);
      return Response.status(200).entity(angebot.getId()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PUT
  @Path("/update")
  public Response updateEntity(Angebot angebot) {
    if (angebot.getId() != null) {
      repository.save(angebot);
      return Response.status(200).entity(angebot.getId()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

}
