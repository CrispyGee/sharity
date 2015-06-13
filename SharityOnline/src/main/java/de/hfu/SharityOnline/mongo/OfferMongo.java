package de.hfu.SharityOnline.mongo;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import de.hfu.SharityOnline.frontend.entities.Category;
import de.hfu.SharityOnline.innerObjects.Availability;

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
  private double price;
  private Availability availability;
  private Category category;
  private String bezeichnung;
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

  public int getAvailability() {
    return availability;
  }

  public void setAvailability(int verfügbarkeit) {
    this.availability = verfügbarkeit;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
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

}
