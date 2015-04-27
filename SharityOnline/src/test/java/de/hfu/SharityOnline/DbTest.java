package de.hfu.SharityOnline;

import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;

public class DbTest {
  
  @Test
  public void test(){
    Repository<Profil> rep = new Repository<Profil>();
    Profil profil = new Profil();
    profil.setId(UUID.randomUUID().toString());
    profil.setNachname("horst");
    profil.setVorname("horsti");
    rep.save(profil);
    System.out.println(rep.loadAll(Profil.class));
  }
  
  

}
