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
  private String benutzername;
  private String anrede;
  @Id private String id;
  private String vorname;
  private String nachname;
  private String plz;
  private String wohnort;
  private Calendar geburtstag;
  private String telefon;
  private String email;
  private String taetigkeit;
  private String studiengang;
  private String klasse;
  private String schulart;
  private String beruf;
  private boolean loggedIn;
  private String referenzen;
  private String selbstportrait;

  
  
  public String getBenutzername() {
    return benutzername;
  }

  public void setBenutzername(String benutzername) {
    this.benutzername = benutzername;
  }

  public String getAnrede() {
    return anrede;
  }

  public void setAnrede(String anrede) {
    this.anrede = anrede;
  }

  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    this.plz = plz;
  }

  public String getWohnort() {
    return wohnort;
  }

  public void setWohnort(String wohnort) {
    this.wohnort = wohnort;
  }

  public String getTelefon() {
    return telefon;
  }

  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTaetigkeit() {
    return taetigkeit;
  }

  public void setTaetigkeit(String taetigkeit) {
    this.taetigkeit = taetigkeit;
  }

  public String getStudiengang() {
    return studiengang;
  }

  public void setStudiengang(String studiengang) {
    this.studiengang = studiengang;
  }

  public String getKlasse() {
    return klasse;
  }

  public void setKlasse(String klasse) {
    this.klasse = klasse;
  }

  public String getSchulart() {
    return schulart;
  }

  public void setSchulart(String schulart) {
    this.schulart = schulart;
  }

  public String getBeruf() {
    return beruf;
  }

  public void setBeruf(String beruf) {
    this.beruf = beruf;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public String getReferenzen() {
    return referenzen;
  }

  public void setReferenzen(String referenzen) {
    this.referenzen = referenzen;
  }

  public String getSelbstportrait() {
    return selbstportrait;
  }

  public void setSelbstportrait(String selbstportrait) {
    this.selbstportrait = selbstportrait;
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

  @Override
  public String toString() {
    return "ProfilFrontend [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", geburtstag=" + geburtstag + "]";
  }
  
}
