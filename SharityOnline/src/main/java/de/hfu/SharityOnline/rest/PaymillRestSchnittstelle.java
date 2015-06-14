package de.hfu.SharityOnline.rest;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.paymill.Paymill;
import de.hfu.SharityOnline.setup.Repository;

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)

public class PaymillRestSchnittstelle {
  private final String jsonErrorMsg = "{Error: \"x\"}";
  private static final Repository<Paymill> repository = new Repository<Paymill>();
  
  @POST
  @Path("/debit/{offer_id}")
  public Response debitLoadEntityById(@PathParam("offer_id") String offer_id) {
    try {
    Paymill pat = repository.loadById(Category.class, offer_id);
    if (pat != null) {
      return Response.status(200).entity(pat).type(MediaType.APPLICATION_JSON).build();
    } else {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "Response 424: Category with id " + pat + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
    } catch(Exception e) {
      return Response.status(500).entity(jsonErrorMsg.replace("x", e.toString())).type(MediaType.APPLICATION_JSON).build();
      }
    }
  
  
  @POST
  @Path("/creditcard/{offer_id}")
  public Response creditLoadEntityById(@PathParam("offer_id") String offer_id) {
    try {
    Paymill pat = repository.loadById(Category.class, offer_id);
    if (pat != null) {
      return Response.status(200).entity(pat).type(MediaType.APPLICATION_JSON).build();
    } else {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "Response 424: Category with id " + pat + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
    } catch(Exception e) {
      return Response.status(500).entity(jsonErrorMsg.replace("x", e.toString())).type(MediaType.APPLICATION_JSON).build();
      }
    }

}
