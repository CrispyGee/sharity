package de.hfu.SharityOnline.entities;

import de.hfu.SharityOnline.innerObjects.OfferDuration;

public class CategoryToken {

  private OfferDuration offerDuration;
  private Category category;
  private String supply_demand;

  public CategoryToken() {
    super();
  }

  public CategoryToken(OfferDuration offerDuration, Category category, String supply_demand) {
    super();
    this.offerDuration = offerDuration;
    this.category = category;
    this.supply_demand = supply_demand;
  }

  public OfferDuration getOfferDuration() {
    return offerDuration;
  }

  public void setOfferDuration(OfferDuration offerDuration) {
    this.offerDuration = offerDuration;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getSupply_demand() {
    return supply_demand;
  }

  public void setSupply_demand(String supply_demand) {
    this.supply_demand = supply_demand;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((offerDuration == null) ? 0 : offerDuration.hashCode());
    result = prime * result + ((supply_demand == null) ? 0 : supply_demand.hashCode());
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
    CategoryToken other = (CategoryToken) obj;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (offerDuration != other.offerDuration)
      return false;
    if (supply_demand == null) {
      if (other.supply_demand != null)
        return false;
    } else if (!supply_demand.equals(other.supply_demand))
      return false;
    return true;
  }

}
