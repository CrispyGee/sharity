package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("pages")
public class Page implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 522215797451368986L;
  
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((main_content == null) ? 0 : main_content.hashCode());
    result = prime * result + ((meta_description == null) ? 0 : meta_description.hashCode());
    result = prime * result + ((meta_keywords == null) ? 0 : meta_keywords.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
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
    Page other = (Page) obj;
    if (main_content == null) {
      if (other.main_content != null)
        return false;
    } else if (!main_content.equals(other.main_content))
      return false;
    if (meta_description == null) {
      if (other.meta_description != null)
        return false;
    } else if (!meta_description.equals(other.meta_description))
      return false;
    if (meta_keywords == null) {
      if (other.meta_keywords != null)
        return false;
    } else if (!meta_keywords.equals(other.meta_keywords))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

}
