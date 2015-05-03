package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.backend.Angebot;
import de.hfu.SharityOnline.backend.Profil;
import de.hfu.SharityOnline.backend.Repository;

public class DbTest {

  // @Test
  // public void testProfil(){
  // Repository<Profil> rep = new Repository<Profil>();
  // Profil profil = new Profil();
  // profil.setId(UUID.randomUUID().toString());
  // profil.setNachname("horst");
  // profil.setVorname("horsti");
  // rep.save(profil);
  // System.out.println(rep.loadAll(Profil.class));
  // }

  // @Test
  // public void testAngebot(){
  // Repository<Angebot> rep = new Repository<Angebot>();
  // for(int i = 0; i < 39; i++) {
  // Angebot angebot= new Angebot();
  // angebot.setId(UUID.randomUUID().toString());
  // angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
  // angebot.setTitel("titelllll");
  // angebot.setBeschreibung("kekekeke");
  // angebot.setPreis(i);
  // angebot.setKategorie("Miep");
  //
  // rep.save(angebot);
  // System.out.println(rep.loadAll(Angebot.class));
  // }
  // }

  public void testIDAngebot() {
    Repository<Angebot> rep = new Repository<Angebot>();
    Angebot angebot = new Angebot();
    angebot.setId("UAARGH");
    angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
    angebot.setTitel("titelllll");
    angebot.setBeschreibung("kekekeke");
    angebot.setPreis(42);
    angebot.setKategorie("Miep");

    rep.save(angebot);
    System.out.println(rep.loadAll(Angebot.class));
  }

  @Test
  public void testIDProfil() {
    Repository<Profil> rep = new Repository<Profil>();
    Profil profil = new Profil();
    profil.setId("aloha");
    profil.setNachname("Für dich");
    profil.setVorname("Falsche Band");
    rep.save(profil);
    System.out.println(rep.loadAll(Profil.class));
  }

}
