package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("categories")
public class Category implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 5442971499116073238L;
  
  @Id
  private String category_id;
  private String category_term;
  
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
  

}
