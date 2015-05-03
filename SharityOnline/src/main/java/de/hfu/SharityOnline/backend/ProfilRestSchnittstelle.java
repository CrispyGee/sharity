package de.hfu.SharityOnline.backend;

import java.util.ArrayList;
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

import org.modelmapper.ModelMapper;

import de.hfu.SharityOnline.frontend.ProfilFrontend;

@Path("/profil")
@Produces(MediaType.APPLICATION_JSON)
public class ProfilRestSchnittstelle extends Application {

//  private final String jsonErrorMsg = "{Error: \"x\"";
//  private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<Profil> REPO = new Repository<Profil>();
  private static final ModelMapper MAPPER = new ModelMapper();

  @GET
  @Path("")
  public Response loadEntity() {
    List<Profil> allProfiles = REPO.loadAll(Profil.class);
    List<ProfilFrontend> allProfilesForFrontend = new ArrayList<ProfilFrontend>();
    for (Profil profil : allProfiles) {
     allProfilesForFrontend.add(MAPPER.map(profil, ProfilFrontend.class)); 
    }
    return Response.status(200).entity(allProfilesForFrontend).type(MediaType.APPLICATION_JSON).build();
  }
  
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    Profil profil = REPO.loadById(Profil.class, id);
    return Response.status(200).entity(profil).type(MediaType.APPLICATION_JSON).build();
  }
  
  @GET
  @Path("/{username}/{pwhash}")
  public Response login(@PathParam("username") String username, @PathParam("pwhash") String pwhash) {
    Profil profil = REPO.loadByKey(Profil.class, "username", username);
    if(profil.getPasswort() == pwhash) {
      profil.setLoggedIn(true);
      return Response.status(200).entity(null).type(MediaType.APPLICATION_JSON).build();
    } else {
      return Response.serverError().entity("Wrong Username or password").build();
    }
  }
  
  @GET
  @Path("/{id}")
  public Response logout(@PathParam("id") String id) {
    Profil profil = REPO.loadById(Profil.class, id);
    profil.setLoggedIn(false);
    return Response.status(200).entity(null).type(MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Path("/create")
  public Response createEntity(Profil profil) {
    if (profil != null && 
          profilanforderungen(profil)) {
      profil.setId(UUID.randomUUID().toString());
      createOrUpdateEntity(profil);
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PUT
  @Path("/update")
  public Response updateEntity(Profil profil) {
    if (profil.getId() != null && profilanforderungen(profil)) {
      createOrUpdateEntity(profil);
    }
    return Response.status(Status.BAD_REQUEST).build();
  }
  

 public Response createOrUpdateEntity(Profil profil) {
   REPO.save(profil);
   profil.setLoggedIn(true);
   return Response.status(200).entity(profil.getId()).type(MediaType.APPLICATION_JSON).build();
 }
  
  public boolean profilanforderungen(Profil profil) {
    if(profil.getBenutzername() != null &&
          profil.getPasswort() != null &&
          profil.getVorname() != null &&
          profil.getNachname() != null &&
          profil.getPlz() != null &&
          profil.getWohnort() != null &&
          profil.getEmail() != null && //TODO - Je nach Tätigkeit, student schüler etc ausfüllen. 
          profil.getTaetigkeit() != null) {
      return true;
    } else {
      return false;
    }
  }
}
