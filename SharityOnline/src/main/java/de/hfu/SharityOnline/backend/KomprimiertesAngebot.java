package de.hfu.SharityOnline.backend;

import java.util.Calendar;

public class KomprimiertesAngebot {
  private static final long serialVersionUID = 1L;
  private int preis;
  private String kategorie;
  private Calendar erstelldatum;
  private String bezeichnung;
  
  public int getPreis() {
    return preis;
  }
  public void setPreis(int preis) {
    this.preis = preis;
  }
  public String getKategorie() {
    return kategorie;
  }
  public void setKategorie(String kategorie) {
    this.kategorie = kategorie;
  }
  public Calendar getErstelldatum() {
    return erstelldatum;
  }
  public void setErstelldatum(Calendar erstelldatum) {
    this.erstelldatum = erstelldatum;
  }
  public String getBezeichnung() {
    return bezeichnung;
  }
  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }
}
