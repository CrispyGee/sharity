package de.hfu.SharityOnline.setup;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.util.Base64;

import de.hfu.SharityOnline.frontend.entities.User;
import de.hfu.SharityOnline.mongo.UserMongo;
import de.hfu.SharityOnline.util.PasswordHasher;

/**
 * This interceptor verify the access permissions for a user based on username
 * and passowrd provided in request
 * */
@Provider
public class SecurityInterceptor implements javax.ws.rs.container.ContainerRequestFilter {
  private static final String AUTHORIZATION_PROPERTY = "Authorization";
  private static final String AUTHENTICATION_SCHEME = "Basic";
  private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401,
      new Headers<Object>());;
  private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403,
      new Headers<Object>());;
  private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500,
      new Headers<Object>());;
  private static final Repository<UserMongo> repository = new Repository<UserMongo>();

  @Override
  public void filter(ContainerRequestContext requestContext) {
    ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext
        .getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
    Method method = methodInvoker.getMethod();
    // Access allowed for all
    if (!method.isAnnotationPresent(PermitAll.class)) {
      // Access denied for all
      if (method.isAnnotationPresent(DenyAll.class)) {
        requestContext.abortWith(ACCESS_FORBIDDEN);
        return;
      }

      // Get request headers
      final MultivaluedMap<String, String> headers = requestContext.getHeaders();

      // Fetch authorization header
      final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

      // If no authorization information present; block access
      if (authorization == null || authorization.isEmpty()) {
        requestContext.abortWith(ACCESS_DENIED);
        return;
      }

      final String usernameAndPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

      // Split username and password tokens
      final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
      final String username = tokenizer.nextToken();
      final String password = tokenizer.nextToken();

      // Verifying Username and password
      System.out.println(username);
      System.out.println(password);

      // Verify user access
      if (method.isAnnotationPresent(RolesAllowed.class)) {
        RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
        Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

        // Is user valid?
        if (!isUserAllowed(username, password, rolesSet)) {
          requestContext.abortWith(ACCESS_DENIED);
          return;
        }
      }
    }
  }

  private boolean isUserAllowed(final String username, final String singleEncryptedPassword, final Set<String> rolesSet) {
    // Step 1. Fetch password from database and match with password in argument
    UserMongo user = repository.loadByKey(UserMongo.class, "username", username);
    // user not found
    if (user == null) {
      return false;
    }
    // password wrong
    String doubleEncryptedPassword = user.getPassword();
    try {
      if (!PasswordHasher.getEncryptor().checkPassword(singleEncryptedPassword, doubleEncryptedPassword)) {
        System.out.println("pw wrong");
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    // Step 2. Verify user role
    if (rolesSet.contains(user.getUserRole())) {
      return true;
    } else {
      return false;
    }
  }

}