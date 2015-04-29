package de.hfu.SharityOnline;

import java.util.UUID;

import org.junit.Test;

import de.hfu.SharityOnline.backend.Angebot;
import de.hfu.SharityOnline.backend.Profil;
import de.hfu.SharityOnline.backend.Repository;

public class DbTest {
  
  @Test
  public void testProfil(){
    Repository<Profil> rep = new Repository<Profil>();
    Profil profil = new Profil();
    profil.setId(UUID.randomUUID().toString());
    profil.setNachname("horst");
    profil.setVorname("horsti");
    rep.save(profil);
    System.out.println(rep.loadAll(Profil.class));
  }
  
  @Test
  public void testAngebot(){
    Repository<Angebot> rep = new Repository<Angebot>();
    Angebot angebot= new Angebot();
    angebot.setId(UUID.randomUUID().toString());
    angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
    angebot.setTitel("titelllll");
    rep.save(angebot);
    System.out.println(rep.loadAll(Angebot.class));
  }

}
