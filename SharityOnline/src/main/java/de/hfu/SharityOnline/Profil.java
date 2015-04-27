package de.hfu.SharityOnline;

import java.io.Serializable;
import java.util.Calendar;

public class Profil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
}
