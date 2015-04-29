package de.hfu.SharityOnline.frontend;

import java.io.Serializable;
import java.util.Calendar;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("Profile")
public class ProfilFrontend implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id private String id;
  private String vorname;
  private String nachname;
  private Calendar geburtstag;

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public Calendar getGeburtstag() {
    return geburtstag;
  }

  public void setGeburtstag(Calendar geburtstag) {
    this.geburtstag = geburtstag;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ProfilFrontend [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", geburtstag=" + geburtstag + "]";
  }
  
}
