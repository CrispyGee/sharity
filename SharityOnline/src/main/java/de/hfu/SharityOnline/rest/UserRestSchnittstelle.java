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
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.setup.PasswordHasher;
import de.hfu.SharityOnline.setup.Repository;

@Path("/user")
public class UserRestSchnittstelle extends Application {
  
  private final String jsonErrorMsg = "{Error: \"x\"}";
  // private final String jsonErrorMsg = "{Error: \"x\"";
  // private final String jsonSuccessMsg = "{Success: \"x\"";
  private static final Repository<UserMongo> repository = new Repository<UserMongo>();

  @RolesAllowed("ADMIN")
  @GET
  @Path("")
  public Response loadEntity() {
    List<UserMongo> allProfiles = repository.loadAll(UserMongo.class);
    return Response.status(200).entity(UserMapper.mapUserListToFrontend(allProfiles)).type(MediaType.APPLICATION_JSON)
        .build();
  }

  @PermitAll
  @GET
  @Path("/{id}")
  public Response loadEntityById(@PathParam("id") String id) {
    try {
    UserMongo user = repository.loadById(UserMongo.class, id);
    user.setPassword(null);
    user.setUsername(null);
    return Response.status(200).entity(UserMapper.mapUserToFrontend(user)).type(MediaType.APPLICATION_JSON).build();
    } catch(Exception e) {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "Response 424: User with id " + id + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
      }
  }

  @PermitAll
  @POST
  @Path("/new")
  public Response createEntity(User user) {
    if (user != null) {
      if (isValid(user)) {
        if(repository.loadByKey(UserMongo.class, "username", user.getUsername())!= null){
          return Response.status(Status.CONFLICT).build();
        }
        try {
          UserMongo userBackend = UserMapper.mapUserToBackend(user);
          userBackend.setId(UUID.randomUUID().toString());
          userBackend.setUserRole("FREE");
          userBackend.setPassword(PasswordHasher.getEncryptor().encryptPassword(user.getPassword()));
          repository.save(userBackend);
        } catch(IllegalArgumentException e) {
          return Response.status(Status.BAD_REQUEST).build();
        }
        return Response.status(Status.ACCEPTED).build();
      }
    return Response.status(Status.BAD_REQUEST).build();
    }
    return Response.status(Status.UNAUTHORIZED).build();
  }

  @PermitAll
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public Response updateEntity(User user) {
    if (user.getId() != null && isValid(user)) {
      UserMongo foundUser = repository.loadById(UserMongo.class, user.getId());
      if (foundUser != null && foundUser.getPassword().equals(user.getPassword())
          && foundUser.getUsername().equals(user.getUsername())) {
        user.setUserRole(foundUser.getUserRole());
        repository.save(UserMapper.mapUserToBackend(user));
        return Response.status(Status.ACCEPTED).build();
      }
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  // @GET
  // @Path("/upgradeAccount/{id}")
  // public Response upgradeAccount(@PathParam("id") String id) {
  // User foundUser = repository.loadById(User.class, id);
  // // TODO Paypal/Paymill check here
  // if (foundUser != null) {
  // foundUser.setUserRole("VERIFIEDUSER");
  // repository.save(foundUser);
  // return Response.status(Status.ACCEPTED).build();
  // }
  // return Response.status(Status.BAD_REQUEST).build();
  // }

  @GET
  @Path("/delete/{id}")
  public Response deleteEntity(@PathParam("id") String id) {
    if (repository.deleteByID(UserMongo.class, id)) {
      return Response.status(200).build();
    } else {
      return Response.status(204).build();
    }

  }
  public boolean isValid(User user) {
    if(user.getUsername() == null || user.getFirstname() == null || user.getLastname() == null || user.getZip() == null || user.getPhone() == null) {
      return false;
    }
    if(!isInsideBorders(user.getUsername(), 1, 20) || 
      !isInsideBorders(user.getLastname(), 1, 15) || user.hasNumbers(user.getLastname()) ||
      !isInsideBorders(user.getFirstname(), 1, 15) || user.hasNumbers(user.getFirstname()) ||
      !user.exact_Char(user.getZip(), 5) || !user.onlyNumbers(user.getZip()) ||
      !isInsideBorders(user.getPhone(), 1, 30) && !user.onlyNumbers(user.getPhone())) {
      return false;
    }
    if(user.getHometown() != null && (user.hasNumbers(user.getHometown()) || !isInsideBorders(user.getHometown(), 1, 15))) {
      return false;
    }
    if(user.getPhone() != null && (!user.onlyNumbers(user.getPhone()) || !isInsideBorders(user.getPhone(), 1, 31))) {
      return false;
    }
    if(user.getBirthday() != 0 && (user.hasNumbers(Long.toString(user.getBirthday())) || !isInsideBorders((Long.toString(user.getBirthday())), 10, 10))) {
      return false;
    }
    return true;
    
  }
  public boolean isInsideBorders(String s, int untergrenze, int obergrenze) {
    if(s.length() <= obergrenze && s.length() >= untergrenze) {
      return true;
    } else {
      return false;
    }
  }
}
