package de.hfu.SharityOnline;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestInit extends Application {

  private Set<Object> singletons = new HashSet<Object>();
  private Set<Class<?>> empty = new HashSet<Class<?>>();

  public RestInit() {
    // ADD YOUR RESTFUL RESOURCES HERE
    this.singletons.add(new ProfilRestSchnittstelle());
    this.singletons.add(new AngebotRestSchnittstelle());
  }

  public Set<Class<?>> getClasses() {
    return this.empty;
  }

  public Set<Object> getSingletons() {
    return this.singletons;
  }

}
