package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import de.hfu.SharityOnline.innerObjects.Availability;
import de.hfu.SharityOnline.innerObjects.OfferDuration;

@Entity("offers")
public class OfferMongo implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  private String offer_id;
  private String title;
  private String description;
  private UserMongo userMongo;
  private double price;
  private OfferDuration offerDuration;
  private Availability availability;
  private Category category;
  private int currency;
  private long creation_date;
  private boolean active;

  public long getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(long creation_date) {
    this.creation_date = creation_date;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double preis) {
    this.price = preis;
  }

  public Availability getAvailability() {
    return availability;
  }

  public void setAvailability(Availability availability) {
    this.availability = availability;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String titel) {
    this.title = titel;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String beschreibung) {
    this.description = beschreibung;
  }

  public String getOffer_id() {
    return offer_id;
  }

  public void setOffer_id(String id) {
    this.offer_id = id;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public int getCurrency() {
    return currency;
  }

  public void setCurrency(int currency) {
    this.currency = currency;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public UserMongo getUserMongo() {
    return userMongo;
  }

  public void setUserMongo(UserMongo userMongo) {
    this.userMongo = userMongo;
  }

  @Override
  public String toString() {
    return "OfferMongo [offer_id=" + offer_id + ", title=" + title + ", description=" + description + ", userMongo="
        + userMongo + ", price=" + price + ", availability=" + availability + ", category=" + category
        + ", currency=" + currency + ", creation_date=" + creation_date + ", active="
        + active + "]";
  }

  public OfferDuration getOfferDuration() {
    return offerDuration;
  }

  public void setOfferDuration(OfferDuration offerDuration) {
    this.offerDuration = offerDuration;
  }
  
}
