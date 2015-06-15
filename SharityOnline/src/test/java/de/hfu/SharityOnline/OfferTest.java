package de.hfu.SharityOnline;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.rest.OfferRestSchnittstelle;

public class OfferTest {
  
  
  public static OfferRestSchnittstelle u = new OfferRestSchnittstelle();
  private static String id = "1";
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  
  public Offer createOffer() {
    incID();
    Offer u = new Offer();
    u.setActive(true);
    u.setAvailability(1);
    u.setCategory_id("Categorie");
    u.setCreation_date(13245L);
    u.setCurrency(1);
    u.setDescription("Eine BEschreibung");
    u.setOffer_id(getId());
    u.setPrice(12.0);
    u.setTitle("Titel");
    u.setUser_id("User_ID");
    return u;
  }
  public void incID() {
   int i = Integer.parseInt(getId());
   i++;
  setId(Integer.toString(i));
}
  @Test
  public void testOffer_Desc_zuLang() {  
    Offer offer = createOffer();
    offer.setDescription("Muuuuuuuuuuuuuuuusssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testOffer_Desc_zuKurz() {
    Offer offer = createOffer();
    offer.setDescription("");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testOffer_Desc_valid() {
    Offer offer = createOffer();
    offer.setDescription("Beschreibung");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 200);
  }
  
  @Test
  public void testOffer_title_zuLang() {  
    Offer offer = createOffer();
    offer.setTitle("Muuuuuuuuuuuuuuuusssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testOffer_title_zuKurz() {
    Offer offer = createOffer();
    offer.setTitle("");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testOffertitle_valid() {
    Offer offer = createOffer();
    offer.setTitle("Beschreibung");
    Response r = u.createEntity(offer);
    assertTrue(r.getStatus() == 200);
  }

}
