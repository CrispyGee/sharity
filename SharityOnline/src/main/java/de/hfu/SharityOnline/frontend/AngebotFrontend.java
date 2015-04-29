package de.hfu.SharityOnline.frontend;

import java.io.Serializable;
import java.util.Calendar;

public class AngebotFrontend implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private String id;
  private String titel;
  private String beschreibung;
  private Calendar gueltigAb;
  private Calendar gueltigBis;

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
    return "AngebotFrontend [id=" + id + ", titel=" + titel + ", beschreibung=" + beschreibung + ", gueltigAb=" + gueltigAb
        + ", gueltigBis=" + gueltigBis + "]";
  }

}
