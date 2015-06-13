package de.hfu.SharityOnline.setup;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import de.hfu.SharityOnline.rest.AngebotRestSchnittstelle;
import de.hfu.SharityOnline.rest.PageRestSchnittstelle;
import de.hfu.SharityOnline.rest.UserRestSchnittstelle;

public class RestInit extends Application {

  private Set<Object> singletons = new HashSet<Object>();
  private Set<Class<?>> empty = new HashSet<Class<?>>();

  public RestInit() {
    // ADD YOUR RESTFUL RESOURCES HERE
    this.singletons.add(new SecurityInterceptor());
    this.singletons.add(new PageRestSchnittstelle());
    this.singletons.add(new UserRestSchnittstelle());
    this.singletons.add(new AngebotRestSchnittstelle());
  }

  public Set<Class<?>> getClasses() {
    return this.empty;
  }

  public Set<Object> getSingletons() {
    return this.singletons;
  }

}