package de.hfu.SharityOnline.entities;


public class Offer {

  private String offer_id;
  private String title;
  private String description;
  private String user_id;
  private String supply_demand;
  private int offer_duration;
  private double price;
  private int availability;
  private String category_id;
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

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public int getOffer_duration() {
    return offer_duration;
  }

  public void setOffer_duration(int offer_duration) {
    this.offer_duration = offer_duration;
  }

  public String getSupply_demand() {
    return supply_demand;
  }

  public void setSupply_demand(String supply_demand) {
    this.supply_demand = supply_demand;
  }
  
  
}
