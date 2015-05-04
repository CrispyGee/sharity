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

//  public void testIDAngebot() {
//    Repository<Angebot> rep = new Repository<Angebot>();
//    Angebot angebot = new Angebot();
//    angebot.setId("UAARGH");
//    angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
//    angebot.setTitel("titelllll");
//    angebot.setBeschreibung("kekekeke");
//    angebot.setPreis(42);
//    angebot.setKategorie("Miep");
//
//    rep.save(angebot);
//    System.out.println(rep.loadAll(Angebot.class));
//  }
//
//  @Test
//  public void testIDProfil() {
//    Repository<Profil> rep = new Repository<Profil>();
//    Profil profil = new Profil();
//    profil.setId("aloha");
//    profil.setNachname("Für dich");
//    profil.setVorname("Falsche Band");
//    rep.save(profil);
//    System.out.println(rep.loadAll(Profil.class));
//  }
  
  @Test
  public void testDummyDatenprofil() {
    Repository<Profil> rep = new Repository<Profil>();
    Profil profil = new Profil();
    profil.setId("1");
    profil.setNachname("Mustermann");
    profil.setVorname("Max");
    profil.setAnrede("Herr");
    profil.setBeruf("Student");
    profil.setEmail("max@mustermann.de");
    profil.setPlz("77955");
    profil.setTelefon("078228942");
    profil.setWohnort("Ettenheim");
    profil.setUsername("mustiman");
    rep.save(profil);
    
    profil.setId("2");
    profil.setNachname("Müller");
    profil.setVorname("Horst");
    profil.setAnrede("Herr");
    profil.setBeruf("Schüler");
    profil.setEmail("müllerhorst@mustermann.de");
    profil.setPlz("1234");
    profil.setTelefon("0007822");
    profil.setWohnort("Furtwangen");
    profil.setUsername("horstimülli");
    rep.save(profil);
    
    profil.setId("3");
    profil.setNachname("Müller");
    profil.setVorname("Sabine");
    profil.setAnrede("Frau");
    profil.setBeruf("Student");
    profil.setEmail("email@domain.de");
    profil.setPlz("78170");
    profil.setTelefon("01782830932");
    profil.setWohnort("Stuttgart");
    profil.setUsername("Binchen");
    rep.save(profil);
    
    profil.setId("4");
    profil.setNachname("Plotzky");
    profil.setVorname("Chris");
    profil.setAnrede("Herr");
    profil.setBeruf("Student");
    profil.setEmail("christian@plotzky.de");
    profil.setPlz("78123");
    profil.setTelefon("0151294024");
    profil.setWohnort("Freiburg");
    profil.setUsername("crispyGee");
    rep.save(profil);
    
    profil.setId("5");
    profil.setNachname("Fischer");
    profil.setVorname("Niklas");
    profil.setAnrede("Herr");
    profil.setBeruf("Azubi");
    profil.setEmail("nf@gmail.de");
    profil.setPlz("77955");
    profil.setTelefon("078228942");
    profil.setWohnort("Ettenheim");
    profil.setUsername("nikki");
    rep.save(profil);
    
    profil.setId("6");
    profil.setNachname("Albach");
    profil.setVorname("Etu");
    profil.setAnrede("Herr");
    profil.setBeruf("Student");
    profil.setEmail("email@random.de");
    profil.setPlz("77953");
    profil.setTelefon("02318942");
    profil.setWohnort("Freudenstadt");
    profil.setUsername("Etualb");
    rep.save(profil);
    
    profil.setId("7");
    profil.setNachname("Günther");
    profil.setVorname("Mannfred");
    profil.setAnrede("Herr");
    profil.setBeruf("Schüler");
    profil.setEmail("fred@gmail.de");
    profil.setPlz("37955");
    profil.setTelefon("004978223123");
    profil.setWohnort("Berlin");
    profil.setUsername("MannfredG");
    rep.save(profil);
    
    profil.setId("8");
    profil.setNachname("Knorke");
    profil.setVorname("Heike");
    profil.setAnrede("Frau");
    profil.setBeruf("Rentner");
    profil.setEmail("heike@rentner.de");
    profil.setPlz("78812");
    profil.setTelefon("0362193");
    profil.setWohnort("Villingen");
    profil.setUsername("knorkeheike");
    rep.save(profil);
    
    profil.setId("9");
    profil.setNachname("Müller");
    profil.setVorname("Elke");
    profil.setAnrede("Frau");
    profil.setBeruf("Selbstständig");
    profil.setEmail("mueller@heike.de");
    profil.setPlz("32342");
    profil.setTelefon("0172894");
    profil.setWohnort("Frankfurt");
    profil.setUsername("Elki");
    rep.save(profil);
    
    profil.setId("10");
    profil.setNachname("Wasser");
    profil.setVorname("Edgar");
    profil.setAnrede("Herr");
    profil.setBeruf("Student");
    profil.setEmail("edgar.wasser@gmail.de");
    profil.setPlz("12345");
    profil.setTelefon("078228942");
    profil.setWohnort("Hamburg");
    profil.setUsername("Wasedgar");
    rep.save(profil);
  }
  @Test
  public void testDummyDatenAngebot() {
    Repository<Angebot> rep = new Repository<Angebot>();
    Angebot angebot = new Angebot();
    angebot.setId("1");
    angebot.setBeschreibung("Biete Nachhilfe in Mathematik");
    angebot.setTitel("Mathe Nachhilfe");
    angebot.setPreis(42);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("2");
    angebot.setBeschreibung("Biete Nachhilfe in Mathematik");
    angebot.setTitel("Mathe Nachhilfe für Schüler");
    angebot.setPreis(60);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("3");
    angebot.setBeschreibung("Biete Nachhilfe in Programmieren");
    angebot.setTitel("Programmieren Grundkurs");
    angebot.setPreis(12);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("4");
    angebot.setBeschreibung("Gassi gehen mit Hund, gerne auch täglich, ohne Bezahlung");
    angebot.setTitel("Hunde ausführen");
    angebot.setPreis(0);
    angebot.setKategorie("Tiere");
    rep.save(angebot);
    
    angebot.setId("5");
    angebot.setBeschreibung("Gartenarbeit für 10 euro die stunde!");
    angebot.setTitel("Hilfe im Garten");
    angebot.setPreis(10);
    angebot.setKategorie("Garten");
    rep.save(angebot);
  
    angebot.setId("6");
    angebot.setBeschreibung("Biete Nachhilfe in Informatik");
    angebot.setTitel("Informatik Nachhilfe");
    angebot.setPreis(19);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("7");
    angebot.setBeschreibung("Biete Nachhilfe in Geschichte");
    angebot.setTitel("Geschichte Nachhilfe");
    angebot.setPreis(15);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("8");
    angebot.setBeschreibung("Haushaltshilfe");
    angebot.setTitel("Helfe im Haus!");
    angebot.setPreis(22);
    angebot.setKategorie("Haus");
    rep.save(angebot);
    
    angebot.setId("9");
    angebot.setBeschreibung("Biete Nachhilfe in Mathematik");
    angebot.setTitel("Mathe Nachhilfe");
    angebot.setPreis(20);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("10");
    angebot.setBeschreibung("Biete Nachhilfe in Mathematik");
    angebot.setTitel("Mathe Nachhilfe");
    angebot.setPreis(15);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("11");
    angebot.setBeschreibung("Biete Nachhilfe in Mathematik");
    angebot.setTitel("Mathe Nachhilfe");
    angebot.setPreis(10);
    angebot.setKategorie("Nachhilfe");
    rep.save(angebot);
    
    angebot.setId("12");
    angebot.setBeschreibung("Koche gerne, Helfe im Haushalt, putze und erledige kleiner Besorgungen");
    angebot.setTitel("Haushaltshilfe");
    angebot.setPreis(20);
    angebot.setKategorie("Haus");
    rep.save(angebot);
    
    angebot.setId("12");
    angebot.setBeschreibung("Babysitte gerne, habe viel Erfahrung, von 2 bis 12 Jahren!");
    angebot.setTitel("Babysitten geboten!");
    angebot.setPreis(42);
    angebot.setKategorie("Babysitten");
    rep.save(angebot);
    
    angebot.setId("13");
    angebot.setBeschreibung("Passe auf ihre Kinder auf, gerne auch abends, bevorzugt am Wochenende");
    angebot.setTitel("Babysitten!");
    angebot.setPreis(10);
    angebot.setKategorie("Babysitten");
    rep.save(angebot);
    
    
    angebot.setId("14");
    angebot.setBeschreibung("Bin ein guter Babysitter, habe schon auf viele Kinder aufgepasst.");
    angebot.setTitel("Kleinkinder hüten");
    angebot.setPreis(15);
    angebot.setKategorie("Babysitten");
    rep.save(angebot);
    
    
    angebot.setId("15");
    angebot.setBeschreibung("Passe gerne tagsüber auf Ihre Kinder auf!");
    angebot.setTitel("Babysitten tagsüber!");
    angebot.setPreis(20);
    angebot.setKategorie("Babysitten");
    rep.save(angebot);
  
  
  }

}
