package de.hfu.SharityOnline;

import org.jboss.resteasy.util.Base64;
import org.junit.Test;

import de.hfu.SharityOnline.frontend.entities.Offer;
import de.hfu.SharityOnline.frontend.entities.User;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.mongo.UserMongo;
import de.hfu.SharityOnline.setup.Repository;

public class DbTest {
  
  @Test
  public void testDummyDatenprofil() {
    Repository<UserMongo> rep = new Repository<UserMongo>();
    User user = new User();
    user.setId("1");
    user.setLastname("Mustermann");
    user.setFirstname("Max");
    user.setUserRole("ADMIN");
    user.setPassword("123");
    user.setUsername("asd");
    user.setSalutation(1);
    user.setSelfportrait("Student");
    user.setEmail("max@mustermann.de");
    user.setZip("77955");
    user.setPhone("078228942");
    user.setHometown("Ettenheim");
    UserMongo userBackend = UserMapper.mapUserToBackend(user);
    String usernameAndPassword = user.getUsername() + ":" + user.getPassword();
    userBackend.setUsernameAndPassword(new String(Base64.encodeBytes(usernameAndPassword.getBytes())));
    rep.save(userBackend);
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
    
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
    rep.save(UserMapper.mapUserToBackend(user));
  }
  @Test
  public void testDummyDatenAngebot() {
    Repository<Offer> rep = new Repository<Offer>();
    Offer offer = new Offer();
    offer.setOffer_id("1");
    offer.setDescription("Biete Nachhilfe in Mathematik");
    offer.setTitle("Mathe Nachhilfe");
    offer.setPrice(42);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("2");
    offer.setDescription("Biete Nachhilfe in Mathematik");
    offer.setTitle("Mathe Nachhilfe für Schüler");
    offer.setPrice(60);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("3");
    offer.setDescription("Biete Nachhilfe in Programmieren");
    offer.setTitle("Programmieren Grundkurs");
    offer.setPrice(12);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("4");
    offer.setDescription("Gassi gehen mit Hund, gerne auch täglich, ohne Bezahlung");
    offer.setTitle("Hunde ausführen");
    offer.setPrice(0);
    offer.setCategory_id("Tiere");
    rep.save(offer);
    
    offer.setOffer_id("5");
    offer.setDescription("Gartenarbeit für 10 euro die stunde!");
    offer.setTitle("Hilfe im Garten");
    offer.setPrice(10);
    offer.setCategory_id("Garten");
    rep.save(offer);
  
    offer.setOffer_id("6");
    offer.setDescription("Biete Nachhilfe in Informatik");
    offer.setTitle("Informatik Nachhilfe");
    offer.setPrice(19);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("7");
    offer.setDescription("Biete Nachhilfe in Geschichte");
    offer.setTitle("Geschichte Nachhilfe");
    offer.setPrice(15);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("8");
    offer.setDescription("Haushaltshilfe");
    offer.setTitle("Helfe im Haus!");
    offer.setPrice(22);
    offer.setCategory_id("Haus");
    rep.save(offer);
    
    offer.setOffer_id("9");
    offer.setDescription("Biete Nachhilfe in Mathematik");
    offer.setTitle("Mathe Nachhilfe");
    offer.setPrice(20);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("10");
    offer.setDescription("Biete Nachhilfe in Mathematik");
    offer.setTitle("Mathe Nachhilfe");
    offer.setPrice(15);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("11");
    offer.setDescription("Biete Nachhilfe in Mathematik");
    offer.setTitle("Mathe Nachhilfe");
    offer.setPrice(10);
    offer.setCategory_id("Nachhilfe");
    rep.save(offer);
    
    offer.setOffer_id("12");
    offer.setDescription("Koche gerne, Helfe im Haushalt, putze und erledige kleiner Besorgungen");
    offer.setTitle("Haushaltshilfe");
    offer.setPrice(20);
    offer.setCategory_id("Haus");
    rep.save(offer);
    
    offer.setOffer_id("12");
    offer.setDescription("Babysitte gerne, habe viel Erfahrung, von 2 bis 12 Jahren!");
    offer.setTitle("Babysitten geboten!");
    offer.setPrice(42);
    offer.setCategory_id("Babysitten");
    rep.save(offer);
    
    offer.setOffer_id("13");
    offer.setDescription("Passe auf ihre Kinder auf, gerne auch abends, bevorzugt am Wochenende");
    offer.setTitle("Babysitten!");
    offer.setPrice(10);
    offer.setCategory_id("Babysitten");
    rep.save(offer);
    
    
    offer.setOffer_id("14");
    offer.setDescription("Bin ein guter Babysitter, habe schon auf viele Kinder aufgepasst.");
    offer.setTitle("Kleinkinder hüten");
    offer.setPrice(15);
    offer.setCategory_id("Babysitten");
    rep.save(offer);
    
    
    offer.setOffer_id("15");
    offer.setDescription("Passe gerne tagsüber auf Ihre Kinder auf!");
    offer.setTitle("Babysitten tagsüber!");
    offer.setPrice(20);
    offer.setCategory_id("Babysitten");
    rep.save(offer);
  
  
  }

}
