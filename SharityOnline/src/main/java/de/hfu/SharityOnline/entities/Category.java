package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import de.hfu.SharityOnline.innerObjects.OfferDuration;

@Entity("categories")
public class Category implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5442971499116073238L;

  @Id
  private String category_id;
  private String category_term;
  private int price_6_months_supply;
  private int price_12_months_supply;
  private int price_6_months_demand;
  private int price_12_months_demand;

  public String getCategory_id() {
    return category_id;
  }

  public void setCategory_id(String category_id) {
    this.category_id = category_id;
  }

  public String getCategory_term() {
    return category_term;
  }

  public void setCategory_term(String category_term) {
    this.category_term = category_term;
  }

  public int getPrice_6_months_supply() {
    return price_6_months_supply;
  }

  public void setPrice_6_months_supply(int price_6_months_supply) {
    this.price_6_months_supply = price_6_months_supply;
  }

  public int getPrice_12_months_supply() {
    return price_12_months_supply;
  }

  public void setPrice_12_months_supply(int price_12_months_supply) {
    this.price_12_months_supply = price_12_months_supply;
  }

  public int getPrice_6_months_demand() {
    return price_6_months_demand;
  }

  public void setPrice_6_months_demand(int price_6_months_demand) {
    this.price_6_months_demand = price_6_months_demand;
  }

  public int getPrice_12_months_demand() {
    return price_12_months_demand;
  }

  public void setPrice_12_months_demand(int price_12_months_demand) {
    this.price_12_months_demand = price_12_months_demand;
  }

  public int getPrice(String supply_demand, OfferDuration offer_duration) throws Exception {
    if (supply_demand.equals("supply")) {
      if (offer_duration.equals(OfferDuration.SECHS_MONATE)) {
        return getPrice_6_months_supply();
      } else if (offer_duration.equals(OfferDuration.ZWOELF_MONATE)) {
        return getPrice_12_months_supply();
      }
    } else if (supply_demand.equals("demand")) {
      if (offer_duration.equals(OfferDuration.SECHS_MONATE)) {
        return getPrice_6_months_demand();
      } else if (offer_duration.equals(OfferDuration.ZWOELF_MONATE)) {
        return getPrice_12_months_demand();
      }
    }
    throw (new Exception("fehler bei supply/demand oder zeitübergabe"));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category_id == null) ? 0 : category_id.hashCode());
    result = prime * result + ((category_term == null) ? 0 : category_term.hashCode());
    result = prime * result + price_12_months_demand;
    result = prime * result + price_12_months_supply;
    result = prime * result + price_6_months_demand;
    result = prime * result + price_6_months_supply;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Category other = (Category) obj;
    if (category_id == null) {
      if (other.category_id != null)
        return false;
    } else if (!category_id.equals(other.category_id))
      return false;
    if (category_term == null) {
      if (other.category_term != null)
        return false;
    } else if (!category_term.equals(other.category_term))
      return false;
    if (price_12_months_demand != other.price_12_months_demand)
      return false;
    if (price_12_months_supply != other.price_12_months_supply)
      return false;
    if (price_6_months_demand != other.price_6_months_demand)
      return false;
    if (price_6_months_supply != other.price_6_months_supply)
      return false;
    return true;
  }

  
  
}
