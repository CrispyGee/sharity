package de.hfu.SharityOnline.mongo;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("pages")
public class PageMongo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  private String id;
  private String title;
  private String meta_description;
  private String meta_keywords;
  private String main_content;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMeta_description() {
    return meta_description;
  }

  public void setMeta_description(String meta_description) {
    this.meta_description = meta_description;
  }

  public String getMeta_keywords() {
    return meta_keywords;
  }

  public void setMeta_keywords(String meta_keywords) {
    this.meta_keywords = meta_keywords;
  }

  public String getMain_content() {
    return main_content;
  }

  public void setMain_content(String main_content) {
    this.main_content = main_content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
