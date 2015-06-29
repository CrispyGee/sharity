package de.hfu.SharityOnline.rest;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.util.Base64;

import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.setup.PasswordEncryptor;
import de.hfu.SharityOnline.setup.Repository;

@Path("/user")
public class UserRestSchnittstelle extends Application {

  private final String jsonErrorMsg = "{\"error\": \"x\"}";
  private static final Repository<UserMongo> repository = new Repository<UserMongo>();

  @RolesAllowed("ADMIN")
  @GET
  @Path("")
  public Response loadEntity() {
    try {
      List<UserMongo> allProfiles = repository.loadAll(UserMongo.class);
      return Response.status(200).entity(UserMapper.mapUserListToFrontend(allProfiles))
          .type(MediaType.APPLICATION_JSON).build();
    } catch (Exception e) {
      return Response.status(424).entity(jsonErrorMsg.replace("x", "No Users found in Database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
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
    } catch (Exception e) {
      return Response.status(424)
          .entity(jsonErrorMsg.replace("x", "Response 424: User with id " + id + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
  }

  @PermitAll
  @GET
  @Path("/username/{name}")
  public Response loadEntityByName(@PathParam("name") String name) {
    try {
      UserMongo user = repository.loadByKey(UserMongo.class, "username", name);
      user.setPassword(null);
      user.setUsername(null);
      return Response.status(200).entity(UserMapper.mapUserToFrontend(user)).type(MediaType.APPLICATION_JSON).build();
    } catch (Exception e) {
      return Response.status(424)
          .entity(jsonErrorMsg.replace("x", "Response 424: User with name " + name + " not found in database."))
          .type(MediaType.APPLICATION_JSON).build();
    }
  }

  @PermitAll
  @POST
  @Path("/new")
  public Response createEntity(User user) {
    if (user != null) {
      if (isValid(user)) {
        if (repository.loadByKey(UserMongo.class, "username", user.getUsername()) != null) {
          return Response.status(Status.CONFLICT).build();
        }
        try {
          UserMongo userBackend = UserMapper.mapUserToBackend(user);
          userBackend.setId(UUID.randomUUID().toString());
          userBackend.setUserRole("FREE");
          try {
            userBackend.setPassword(PasswordEncryptor.encodePassword(user.getPassword()));
          } catch (Exception e) {
            e.printStackTrace();
          }
          repository.save(userBackend);
        } catch (IllegalArgumentException e) {
          return Response.status(Status.BAD_REQUEST).build();
        }
        return Response.status(Status.ACCEPTED).build();
      }
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PermitAll
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public Response updateEntity(User user) throws Exception {
    if (user.getId() != null) {
      UserMongo foundUser = repository.loadById(UserMongo.class, user.getId());
      if (foundUser != null && foundUser.getPassword().equals(PasswordEncryptor.encodePassword(user.getPassword()))
          && foundUser.getUsername().equals(user.getUsername())) {
        user.setUserRole(foundUser.getUserRole());
        user.setPassword(PasswordEncryptor.encodePassword(user.getPassword()));
        repository.save(UserMapper.mapUserToBackend(user));
        return Response.status(Status.ACCEPTED).build();
      }
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PermitAll
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/edit")
  public Response editEntity(@CookieParam("sharityuser") String sharityuser,
      @CookieParam("sharitypw") String sharitypw, User user) throws Exception {
    UserMongo foundUser = repository.loadByKey(UserMongo.class, "username", sharityuser);
    if (foundUser != null && foundUser.getPassword().equals(PasswordEncryptor.encodePassword(sharitypw))
        && foundUser.getUsername().equals(user.getUsername())) {
      user.setId(foundUser.getId());
      user.setUserRole(foundUser.getUserRole());
      if (!foundUser.getPassword().equals(PasswordEncryptor.encodePassword(user.getPassword()))) {
        user.setPassword(PasswordEncryptor.encodePassword(user.getPassword()));
      }
      repository.save(UserMapper.mapUserToBackend(user));
      return Response.status(Status.ACCEPTED).build();
    }
    return Response.status(Status.BAD_REQUEST).build();
  }

  @PermitAll
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/login/{username}")
  public Response login(@PathParam("username") String username, @HeaderParam("passwordhash") String passwordhash) {
    try {
      UserMongo user = repository.loadByKey(UserMongo.class, "username", username);
      if (user.getPassword().equals(PasswordEncryptor.encodePassword(passwordhash))) {
        String cookie = "{\"sharitylogin\" : \"" + Base64.encodeBytes((username + " " + user.getPassword()).getBytes())
            + "\"}";
        System.out.println(cookie + " success");
        return Response.status(200).entity(cookie).type(MediaType.APPLICATION_JSON).build();
      } else {
        System.out.println("wrong pw: " + passwordhash);
        return Response.status(424).entity("Passwort falsch").type(MediaType.APPLICATION_JSON).build();
      }
    } catch (Exception e) {
      System.out.println("Buggg: " + username + passwordhash);
      return Response.status(424).entity("Benutzer nicht gefunden").type(MediaType.APPLICATION_JSON).build();
    }
  }

  @PermitAll
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/login/who")
  public Response loggedInAs(@HeaderParam("sharitylogin") String sharitylogin) {
    try {
      System.out.println(sharitylogin);
      String cookie = new String(Base64.decode(sharitylogin));
      System.out.println(cookie);
      String username = cookie.split(" ")[0];
      System.out.println(username);
      String password = cookie.split(" ")[1];
      System.out.println(password);
      UserMongo user = repository.loadByKey(UserMongo.class, "username", username);
      if (user.getPassword().equals(password)) {
        return Response.status(200).entity(UserMapper.mapUserToFrontend(user)).type(MediaType.APPLICATION_JSON).build();
      }
      return Response.status(424).entity("Kein gueltiges Login Token").type(MediaType.APPLICATION_JSON).build();
    } catch (Exception e) {
      System.out.println("Buggg: User not found");
      return Response.status(424).entity("Benutzer nicht gefunden").type(MediaType.APPLICATION_JSON).build();
    }
  }

  @RolesAllowed("ADMIN")
  @GET
  @Path("/delete/{id}")
  public Response deleteEntity(@PathParam("id") String id) {
    if (repository.deleteByID(UserMongo.class, id)) {
      return Response.status(200).build();
    } else {
      return Response.status(204).build();
    }

  }
  
  @RolesAllowed("ADMIN")
  @GET
  @Path("/delete/username/{name}")
  public Response deleteEntitybyName(@PathParam("name") String name) {
    String id = repository.loadByKey(UserMongo.class, "username", name).getId();
    if (repository.deleteByID(UserMongo.class, id)) {
      return Response.status(200).build();
    } else {
      return Response.status(204).build();
    }

  }

  public boolean isValid(User user) { // TODO: Passwort?
    if (user.getUsername() == null || user.getFirstname() == null || user.getLastname() == null
        || user.getZip() == null || user.getHometown() == null || user.getEmail() == null) {
      return false;
    }
    if (repository.loadByKey(UserMongo.class, "username", user.getUsername()) != null) {
      return false;
    }
    if (!isInsideBorders(user.getUsername(), 1, 20) || !isInsideBorders(user.getLastname(), 1, 15)
        || user.hasNumbers(user.getLastname()) || !isInsideBorders(user.getFirstname(), 1, 15)
        || user.hasNumbers(user.getFirstname()) || !user.exact_Char(user.getZip(), 5)
        || !user.onlyNumbers(user.getZip()) || !isInsideBorders(user.getPhone(), 1, 30)
        && !user.onlyNumbers(user.getPhone())) {
      return false;
    }
    if (user.getHometown() != null
        && (user.hasNumbers(user.getHometown()) || !isInsideBorders(user.getHometown(), 1, 15))) {
      return false;
    }
    if (user.getPhone() != null && (!user.onlyNumbers(user.getPhone()) || !isInsideBorders(user.getPhone(), 1, 31))) {
      return false;
    }
    if (user.getBirthday() != 0
        && (user.hasNumbers(Long.toString(user.getBirthday())) || !isInsideBorders((Long.toString(user.getBirthday())),
            10, 10))) {
      return false;
    }
    return true;

  }

  public boolean isInsideBorders(String s, int untergrenze, int obergrenze) {
    if (s.length() <= obergrenze && s.length() >= untergrenze) {
      return true;
    } else {
      return false;
    }
  }

}
