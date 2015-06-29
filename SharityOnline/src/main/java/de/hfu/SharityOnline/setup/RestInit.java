package de.hfu.SharityOnline.setup;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

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
    CorsFilter corsFilter = new CorsFilter();
    corsFilter.getAllowedOrigins().add("*");
    this.singletons.add(new SecurityInterceptor());
    this.singletons.add(new PageRestSchnittstelle());
    this.singletons.add(new UserRestSchnittstelle());
    this.singletons.add(new CategoryRestSchnittstelle());
    this.singletons.add(new OfferRestSchnittstelle());
    this.singletons.add(new PaymillRestSchnittstelle());
  }

  public Set<Class<?>> getClasses() {
    return this.empty;
  }

  public Set<Object> getSingletons() {
    return this.singletons;
  }

}
