package de.hfu.SharityOnline.rest;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.mapper.OfferMapper;
import de.hfu.SharityOnline.setup.Repository;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)

public class CategoryRestSchnittstelle {
  private final String jsonErrorMsg = "{Error: \"x\"}";
  private static final Repository<Category> repository = new Repository<Category>();

  @PermitAll
  @GET
  @Path("")
  public Response loadEntity() {
    List<Category> allCategories = repository.loadAll(Category.class); //TODO: richtige ausgabe..
    return Response.status(200).entity(allCategories).type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/{category_id}")
  public Response loadEntityById(@PathParam("category_id") String category_id) {
    try {
    Category cat = repository.loadById(Category.class, category_id);
    if (cat != null) {
      return Response.status(200).entity(cat).type(MediaType.APPLICATION_JSON).build();
    } else {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "Response 424: Category with id " + category_id + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
    } catch(Exception e) {
      return Response.status(500).entity(jsonErrorMsg.replace("x", e.toString())).type(MediaType.APPLICATION_JSON).build();
      }
    }
  
  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("/new")
  public Response createEntity(Category category) {
    if (category != null) {
      repository.save(category);
      return Response.status(200).entity(category.getCategory_id()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }
}
