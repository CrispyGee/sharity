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

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.setup.Repository;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)

public class CategoryRestSchnittstelle {
  // private final String jsonErrorMsg = "{Error: \"x\"";
  // private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Category> repository = new Repository<Category>();

  @PermitAll
  @GET
  @Path("")
  public Response loadEntity() {
    List<Category> allCategories = repository.loadAll(Category.class);
    return Response.status(200).entity(allCategories).type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/{category_id}")
  public Response loadEntityById(@PathParam("category_id") String category_id) {
    Category cat = repository.loadById(Category.class, category_id);
    return Response.status(200).entity(cat).type(MediaType.APPLICATION_JSON).build();
  }
}
