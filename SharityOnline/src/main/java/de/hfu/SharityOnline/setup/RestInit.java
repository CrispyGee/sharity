package de.hfu.SharityOnline.setup;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import de.hfu.SharityOnline.polling.OffersPolling;
import de.hfu.SharityOnline.rest.OfferRestSchnittstelle;
import de.hfu.SharityOnline.rest.CategoryRestSchnittstelle;
import de.hfu.SharityOnline.rest.PageRestSchnittstelle;
import de.hfu.SharityOnline.rest.PaymillRestSchnittstelle;
import de.hfu.SharityOnline.rest.UserRestSchnittstelle;

public class RestInit extends Application {

  private Set<Object> singletons = new HashSet<Object>();
  private Set<Class<?>> empty = new HashSet<Class<?>>();

  public RestInit() {
    // ADD YOUR RESTFUL RESOURCES HERE
    OffersPolling.startPolling();
    this.singletons.add(addCorsFilter());
    this.singletons.add(new SecurityInterceptor());
    this.singletons.add(new PageRestSchnittstelle());
    this.singletons.add(new UserRestSchnittstelle());
    this.singletons.add(new CategoryRestSchnittstelle());
    this.singletons.add(new OfferRestSchnittstelle());
    this.singletons.add(new PaymillRestSchnittstelle());
  }

  private CorsFilter addCorsFilter() {
    CorsFilter corsFilter = new CorsFilter();
    return corsFilter;
  }

  public Set<Class<?>> getClasses() {
    return this.empty;
  }

  public Set<Object> getSingletons() {
    return this.singletons;
  }

}
