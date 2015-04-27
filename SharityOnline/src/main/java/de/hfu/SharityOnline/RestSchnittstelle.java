package de.hfu.SharityOnline;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("")
public class RestSchnittstelle extends Application {

  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  public Response helloworld() {
    Repository<Profil> rep = new Repository<Profil>();
    List<Profil> x = rep.loadAll(Profil.class);
    return Response.status(200).entity(x).type(MediaType.APPLICATION_JSON).build();
  }

}
