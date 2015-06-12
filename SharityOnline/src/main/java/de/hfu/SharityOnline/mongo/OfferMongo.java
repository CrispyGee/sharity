package de.hfu.SharityOnline.mongo;

import java.io.Serializable;
import java.util.Calendar;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("offers")
public class OfferMongo implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  private String id;
  private String titel;
  private String beschreibung;
  private Calendar gueltigAb;
  private Calendar gueltigBis;
  private int preis;
  private int verfügbarkeit;
  private String kategorie;
  private Calendar erstelldatum;
  private String bezeichnung;

  public int getPreis() {
    return preis;
  }

  public void setPreis(int preis) {
    this.preis = preis;
  }

  public int getVerfügbarkeit() {
    return verfügbarkeit;
  }

  public void setVerfügbarkeit(int verfügbarkeit) {
    this.verfügbarkeit = verfügbarkeit;
  }

  public String getKategorie() {
    return kategorie;
  }

  public void setKategorie(String kategorie) {
    this.kategorie = kategorie;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public Calendar getGueltigAb() {
    return gueltigAb;
  }

  public void setGueltigAb(Calendar gueltigAb) {
    this.gueltigAb = gueltigAb;
  }

  public Calendar getGueltigBis() {
    return gueltigBis;
  }

  public void setGueltigBis(Calendar gueltigBis) {
    this.gueltigBis = gueltigBis;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "OfferMongo [id=" + id + ", titel=" + titel + ", beschreibung=" + beschreibung + ", gueltigAb=" + gueltigAb
        + ", gueltigBis=" + gueltigBis + "]";
  }

  public Calendar getErstelldatum() {
    return erstelldatum;
  }

  public void setErstelldatum(Calendar erstelldatum) {
    this.erstelldatum = erstelldatum;
  }

}
