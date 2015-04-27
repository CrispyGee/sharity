package de.hfu.SharityOnline;

import java.io.Serializable;
import java.util.Calendar;

public class Angebot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	

}
