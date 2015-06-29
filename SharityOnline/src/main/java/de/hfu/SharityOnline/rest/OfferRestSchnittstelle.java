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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.elasticsearch.index.query.FilterBuilder;

import de.hfu.SharityOnline.elastic.Search;
import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.CategoryToken;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.innerObjects.OfferDuration;
import de.hfu.SharityOnline.mapper.OfferMapper;
import de.hfu.SharityOnline.setup.Repository;

@Path("/offer")
@Produces(MediaType.APPLICATION_JSON)
public class OfferRestSchnittstelle {
  private final String jsonErrorMsg = "{\"error\": \"x\"}";

  private static final Repository<OfferMongo> OFFER_REPO = new Repository<OfferMongo>();
  private static final Repository<UserMongo> USER_REPO = new Repository<UserMongo>();
  private static final Search search = new Search();

  @PermitAll
  @GET
  @Path("")
  public Response loadEntity() {
    List<OfferMongo> alleAngebote = OFFER_REPO.loadAll(OfferMongo.class);
    return Response.status(200).entity(OfferMapper.mapOfferListToFrontend(alleAngebote))
        .type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    try {
      OfferMongo offer = OFFER_REPO.loadById(OfferMongo.class, id);
      return Response.status(200).entity(OfferMapper.mapOfferToFrontend(offer)).type(MediaType.APPLICATION_JSON)
          .build();
    } catch (Exception e) {
      return Response.status(424)
          .entity(jsonErrorMsg.replace("x", "Response 424: Offer with id " + id + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
  }
  
  @PermitAll
  @GET
  @Path("/{username}/{offername}")
  public Response loadEntityById(@PathParam("username") String username, @PathParam("offername") String offername) {
    try {
      List<OfferMongo> alleAngebote = OFFER_REPO.loadAll(OfferMongo.class);
      for (OfferMongo offerMongo : alleAngebote) {
        if (offerMongo.getUserMongo().getUsername().equals(username)&& offerMongo.getTitle().equals(offername)) {
          return Response.status(200).entity(OfferMapper.mapOfferToFrontend(offerMongo)).type(MediaType.APPLICATION_JSON)
              .build();
        }
      }
    } catch (Exception e) {
      return Response.status(424)
          .entity(jsonErrorMsg.replace("x", "Response 424: Offer with titel " + offername + "by user: " + username +" not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(424)
        .entity(jsonErrorMsg.replace("x", "Response 424: Offer with titel " + offername + " by user: " + username +" not found in database."))
        .type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("/search/{term}")
  public Response searchFulltext(@PathParam("term") String term) {
    List<OfferMongo> offerMongoList = search.searchAllActive(term);
    List<Offer> offers = OfferMapper.mapOfferListToFrontend(offerMongoList);
    return Response.status(200).entity(offers).type(MediaType.APPLICATION_JSON).build();
  }

  @PermitAll
  @GET
  @Path("search/{term}/{login_state}")
  public Response searchFilteredQuery(@PathParam("term") String term, @PathParam("login_state") String login_state,
      @QueryParam("salutation") Integer salutation, @QueryParam("hometown") String hometown,
      @QueryParam("within") Double within, @QueryParam("age") Integer age, @QueryParam("price") Double price,
      @QueryParam("availability") Integer availability, @QueryParam("category_id") String category_id,
      @QueryParam("creation_date") Long creation_date) {
    System.out.println(login_state + " " + salutation + " " + hometown + " " + within + " " + age + " " + price + " "
        + availability + " " + category_id + " " + creation_date);
    FilterBuilder filter = search.mapFilterCriteria(login_state, salutation, hometown, within, age, price,
        availability, category_id, creation_date);
    List<OfferMongo> offerMongoList = search.searchActiveWithFilter(filter, term);
    List<Offer> offers = OfferMapper.mapOfferListToFrontend(offerMongoList);
    return Response.status(200).entity(offers).type(MediaType.APPLICATION_JSON).build();
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("/new")
  public Response createEntity(Offer offer) {
    if (offer != null && angebotAnforderung(offer)) {
      UserMongo userMongo = USER_REPO.loadById(UserMongo.class, offer.getUser_id());
      if (userMongo != null) {
        offer.setOffer_id(UUID.randomUUID().toString());
        OfferMongo offerMongo = OfferMapper.mapOfferToBackend(offer);
        CategoryToken categoryToken = new CategoryToken();
        categoryToken.setCategory(offerMongo.getCategory());
        categoryToken.setSupply_demand(offerMongo.getSupply_demand());
        categoryToken.setOfferDuration(offerMongo.getOfferDuration());
        if (userMongo.removeOfferCategoryToken(categoryToken)) {
          OFFER_REPO.save(offerMongo);
          return Response.status(200).entity(offer.getOffer_id()).type(MediaType.APPLICATION_JSON).build();
        } else {
          return Response
              .status(Status.FORBIDDEN)
              .entity(
                  jsonErrorMsg.replace("x",
                      "User was not allowed to create offer with this category, since no payment for it was done."))
              .build();
        }
      } else {
        return Response.status(Status.FORBIDDEN).entity(jsonErrorMsg.replace("x", "User not found")).build();
      }
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @RolesAllowed({ "ADMIN" })
  @PUT
  @Path("/update")
  public Response updateEntity(Offer offer) {
    if (offer.getOffer_id() != null && angebotAnforderung(offer)) {
      OFFER_REPO.save(OfferMapper.mapOfferToBackend(offer));
      return Response.status(200).entity(offer.getOffer_id()).type(MediaType.APPLICATION_JSON).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @RolesAllowed({ "ADMIN" })
  @GET
  @Path("/delete/{id}")
  public Response deleteEntity(@PathParam("id") String id) {
    if (OFFER_REPO.deleteByID(OfferMongo.class, id)) {
      return Response.status(200).build();
    } else {
      return Response.status(204).build();
    }

  }

  public boolean angebotAnforderung(Offer offer) {
    if (Integer.toString(offer.getAvailability()) == null || offer.getCategory_id() == null
        || Long.toString(offer.getCreation_date()) == null || offer.getOffer_id() == null
        || offer.getDescription() == null || offer.getTitle() == null || offer.getUser_id() == null
        || Double.toString(offer.getPrice()) == null) {
      return false;
    }
    if (offer.getTitle().length() < 1 || offer.getTitle().length() > 100) {
      return false;
    }
    if (offer.getDescription().length() < 1 || offer.getDescription().length() > 200) {
      return false;
    }
    return true;
  }

}
