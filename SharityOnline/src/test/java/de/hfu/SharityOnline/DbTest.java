package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.setup.Repository;

public class DbTest {

  // @Test
  // public void testProfil(){
  // Repository<User> rep = new Repository<User>();
  // User profil = new User();
  // profil.setId(UUID.randomUUID().toString());
  // profil.setLastname("horst");
  // profil.setFirstname("horsti");
  // rep.save(profil);
  // System.out.println(rep.loadAll(User.class));
  // }

  // @Test
  // public void testAngebot(){
  // Repository<Offer> rep = new Repository<Offer>();
  // for(int i = 0; i < 39; i++) {
  // Offer angebot= new Offer();
  // angebot.setId(UUID.randomUUID().toString());
  // angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
  // angebot.setTitel("titelllll");
  // angebot.setBeschreibung("kekekeke");
  // angebot.setPreis(i);
  // angebot.setKategorie("Miep");
  //
  // rep.save(angebot);
  // System.out.println(rep.loadAll(Offer.class));
  // }
  // }

//  public void testIDAngebot() {
//    Repository<Offer> rep = new Repository<Offer>();
//    Offer angebot = new Offer();
//    angebot.setId("UAARGH");
//    angebot.setBeschreibung("beschreibung huehuehuehhue asasdasd");
//    angebot.setTitel("titelllll");
//    angebot.setBeschreibung("kekekeke");
//    angebot.setPreis(42);
//    angebot.setKategorie("Miep");
//
//    rep.save(angebot);
//    System.out.println(rep.loadAll(Offer.class));
//  }
//
//  @Test
//  public void testIDProfil() {
//    Repository<User> rep = new Repository<User>();
//    User profil = new User();
//    profil.setId("aloha");
//    profil.setLastname("Für dich");
//    profil.setFirstname("Falsche Band");
//    rep.save(profil);
//    System.out.println(rep.loadAll(User.class));
//  }
  
  @Test
  public void testDummyDatenprofil() {
    Repository<User> rep = new Repository<User>();
    User user = new User();
    user.setId("1");
    user.setLastname("Mustermann");
    user.setFirstname("Max");
    user.setSalutation(1);
    user.setSelfportrait("Student");
    user.setEmail("max@mustermann.de");
    user.setZip("77955");
    user.setPhone("078228942");
    user.setHometown("Ettenheim");
    user.setUsername("mustiman");
    rep.save(user);
    
    user.setId("2");
    user.setLastname("Müller");
    user.setFirstname("Horst");
    user.setSalutation(1);
    user.setSelfportrait("Schüler");
    user.setEmail("müllerhorst@mustermann.de");
    user.setZip("1234");
    user.setPhone("0007822");
    user.setHometown("Furtwangen");
    user.setUsername("horstimülli");
    rep.save(user);
    
    user.setId("3");
    user.setLastname("Müller");
    user.setFirstname("Sabine");
    user.setSalutation(0);
    user.setSelfportrait("Student");
    user.setEmail("email@domain.de");
    user.setZip("78170");
    user.setPhone("01782830932");
    user.setHometown("Stuttgart");
    user.setUsername("Binchen");
    rep.save(user);
    
    user.setId("4");
    user.setLastname("Plotzky");
    user.setFirstname("Chris");
    user.setSalutation(1);
    user.setSelfportrait("Student");
    user.setEmail("christian@plotzky.de");
    user.setZip("78123");
    user.setPhone("0151294024");
    user.setHometown("Freiburg");
    user.setUsername("crispyGee");
    rep.save(user);
    
    user.setId("5");
    user.setLastname("Fischer");
    user.setFirstname("Niklas");
    user.setSalutation(1);
    user.setSelfportrait("Azubi");
    user.setEmail("nf@gmail.de");
    user.setZip("77955");
    user.setPhone("078228942");
    user.setHometown("Ettenheim");
    user.setUsername("nikki");
    rep.save(user);
    
    user.setId("6");
    user.setLastname("Albach");
    user.setFirstname("Etu");
    user.setSalutation(1);
    user.setSelfportrait("Student");
    user.setEmail("email@random.de");
    user.setZip("77953");
    user.setPhone("02318942");
    user.setHometown("Freudenstadt");
    user.setUsername("Etualb");
    rep.save(user);
    
    user.setId("7");
    user.setLastname("Günther");
    user.setFirstname("Mannfred");
    user.setSalutation(1);
    user.setSelfportrait("Schüler");
    user.setEmail("fred@gmail.de");
    user.setZip("37955");
    user.setPhone("004978223123");
    user.setHometown("Berlin");
    user.setUsername("MannfredG");
    rep.save(user);
    
    user.setId("8");
    user.setLastname("Knorke");
    user.setFirstname("Heike");
    user.setSalutation(0);
    user.setSelfportrait("Rentner");
    user.setEmail("heike@rentner.de");
    user.setZip("78812");
    user.setPhone("0362193");
    user.setHometown("Villingen");
    user.setUsername("knorkeheike");
    rep.save(user);
    
    user.setId("9");
    user.setLastname("Müller");
    user.setFirstname("Elke");
    user.setSalutation(0);
    user.setSelfportrait("Selbstständig");
    user.setEmail("mueller@heike.de");
    user.setZip("32342");
    user.setPhone("0172894");
    user.setHometown("Frankfurt");
    user.setUsername("Elki");
    rep.save(user);
    
    user.setId("10");
    user.setLastname("Wasser");
    user.setFirstname("Edgar");
    user.setSalutation(1);
    user.setSelfportrait("Student");
    user.setEmail("edgar.wasser@gmail.de");
    user.setZip("12345");
    user.setPhone("078228942");
    user.setHometown("Hamburg");
    user.setUsername("Wasedgar");
    rep.save(user);
  }
  @Test
  public void testDummyDatenAngebot() {
    Repository<Offer> rep = new Repository<Offer>();
    Offer offer = new Offer();
    offer.setId("1");
    offer.setBeschreibung("Biete Nachhilfe in Mathematik");
    offer.setTitel("Mathe Nachhilfe");
    offer.setPreis(42);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("2");
    offer.setBeschreibung("Biete Nachhilfe in Mathematik");
    offer.setTitel("Mathe Nachhilfe für Schüler");
    offer.setPreis(60);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("3");
    offer.setBeschreibung("Biete Nachhilfe in Programmieren");
    offer.setTitel("Programmieren Grundkurs");
    offer.setPreis(12);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("4");
    offer.setBeschreibung("Gassi gehen mit Hund, gerne auch täglich, ohne Bezahlung");
    offer.setTitel("Hunde ausführen");
    offer.setPreis(0);
    offer.setKategorie("Tiere");
    rep.save(offer);
    
    offer.setId("5");
    offer.setBeschreibung("Gartenarbeit für 10 euro die stunde!");
    offer.setTitel("Hilfe im Garten");
    offer.setPreis(10);
    offer.setKategorie("Garten");
    rep.save(offer);
  
    offer.setId("6");
    offer.setBeschreibung("Biete Nachhilfe in Informatik");
    offer.setTitel("Informatik Nachhilfe");
    offer.setPreis(19);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("7");
    offer.setBeschreibung("Biete Nachhilfe in Geschichte");
    offer.setTitel("Geschichte Nachhilfe");
    offer.setPreis(15);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("8");
    offer.setBeschreibung("Haushaltshilfe");
    offer.setTitel("Helfe im Haus!");
    offer.setPreis(22);
    offer.setKategorie("Haus");
    rep.save(offer);
    
    offer.setId("9");
    offer.setBeschreibung("Biete Nachhilfe in Mathematik");
    offer.setTitel("Mathe Nachhilfe");
    offer.setPreis(20);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("10");
    offer.setBeschreibung("Biete Nachhilfe in Mathematik");
    offer.setTitel("Mathe Nachhilfe");
    offer.setPreis(15);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("11");
    offer.setBeschreibung("Biete Nachhilfe in Mathematik");
    offer.setTitel("Mathe Nachhilfe");
    offer.setPreis(10);
    offer.setKategorie("Nachhilfe");
    rep.save(offer);
    
    offer.setId("12");
    offer.setBeschreibung("Koche gerne, Helfe im Haushalt, putze und erledige kleiner Besorgungen");
    offer.setTitel("Haushaltshilfe");
    offer.setPreis(20);
    offer.setKategorie("Haus");
    rep.save(offer);
    
    offer.setId("12");
    offer.setBeschreibung("Babysitte gerne, habe viel Erfahrung, von 2 bis 12 Jahren!");
    offer.setTitel("Babysitten geboten!");
    offer.setPreis(42);
    offer.setKategorie("Babysitten");
    rep.save(offer);
    
    offer.setId("13");
    offer.setBeschreibung("Passe auf ihre Kinder auf, gerne auch abends, bevorzugt am Wochenende");
    offer.setTitel("Babysitten!");
    offer.setPreis(10);
    offer.setKategorie("Babysitten");
    rep.save(offer);
    
    
    offer.setId("14");
    offer.setBeschreibung("Bin ein guter Babysitter, habe schon auf viele Kinder aufgepasst.");
    offer.setTitel("Kleinkinder hüten");
    offer.setPreis(15);
    offer.setKategorie("Babysitten");
    rep.save(offer);
    
    
    offer.setId("15");
    offer.setBeschreibung("Passe gerne tagsüber auf Ihre Kinder auf!");
    offer.setTitel("Babysitten tagsüber!");
    offer.setPreis(20);
    offer.setKategorie("Babysitten");
    rep.save(offer);
  
  
  }

}
