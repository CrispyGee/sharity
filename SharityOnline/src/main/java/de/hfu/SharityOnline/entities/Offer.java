package de.hfu.SharityOnline.entities;


public class Offer {

  private String offer_id;
  private String title;
  private String description;
  private double price;
  private int availability;
  private String category_id;
  private String bezeichnung;
  private int currency;
  private long creation_date;
  private boolean active;
  
  public Offer(){
    this.creation_date=System.currentTimeMillis();
  }

  public String getOffer_id() {
    return offer_id;
  }

  public void setOffer_id(String offer_id) {
    this.offer_id = offer_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getAvailability() {
    return availability;
  }

  public void setAvailability(int availability) {
    this.availability = availability;
  }

  public String getCategory_id() {
    return category_id;
  }

  public void setCategory_id(String category_id) {
    this.category_id = category_id;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public int getCurrency() {
    return currency;
  }

  public void setCurrency(int currency) {
    this.currency = currency;
  }

  public long getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(long creation_date) {
    this.creation_date = creation_date;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
  
  
}
