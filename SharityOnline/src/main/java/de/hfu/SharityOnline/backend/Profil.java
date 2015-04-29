package de.hfu.SharityOnline.backend;

import java.io.Serializable;
import java.util.Calendar;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity("Profile")
public class Profil implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id private String id;
  private String vorname;
  private String nachname;
  private Calendar geburtstag;
  private String password;
  private boolean loggedIn;

@Indexed(unique = true)
  private String username;

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
  
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String loginName) {
    this.username = loginName;
  }
  
  @Override
  public String toString() {
    return "ProfilFrontend [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", geburtstag=" + geburtstag + "]";
  }
}
