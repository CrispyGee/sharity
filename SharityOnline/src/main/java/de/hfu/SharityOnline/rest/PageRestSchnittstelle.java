package de.hfu.SharityOnline.rest;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hfu.SharityOnline.frontend.entities.Page;
import de.hfu.SharityOnline.setup.Repository;

@Path("/page")
@Produces(MediaType.APPLICATION_JSON)
public class PageRestSchnittstelle {

  private final String jsonErrorMsg = "{Error: \"x\"";
  // private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Page> repository = new Repository<Page>();

  @PermitAll
  @GET
  @Path("")
  public Response loadEntity() {
    List<Page> allepagee = repository.loadAll(Page.class);
    return Response.status(200).entity(allepagee).type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    try{
    Page page = repository.loadById(Page.class, id);
    if (page != null) {
      return Response.status(200).entity(page).type(MediaType.APPLICATION_JSON).build();
    } else {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "Page with id " + id + " not found in database"))
          .type(MediaType.APPLICATION_JSON).build();
    }
    }
    catch(Exception e){
      return Response.status(500).entity(jsonErrorMsg.replace("x", e.toString())).type(MediaType.APPLICATION_JSON).build();
    }
  }

  @RolesAllowed({ "ADMIN", "VERIFIEDUSER" })
  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("/new")
  public Response createEntity(Page page) {
    if (page != null) {
      page.setId(UUID.randomUUID().toString());
      repository.save(page);
      return Response.status(200).entity(page.getId()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

}
