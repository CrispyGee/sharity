package de.hfu.SharityOnline.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.mapper.OfferMapper;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.setup.Repository;

@Path("/test")
public class TestRestSchnittstelle {

  private static final Repository<OfferMongo> OFFER_REPO = new Repository<OfferMongo>();
  private static final Repository<UserMongo> USER_REPO = new Repository<UserMongo>();
  private static final Repository<Category> CAT_REPO = new Repository<Category>();

  private static int userid = 0;
  private static int offerid = 0;

  private void createOfferWithArguments(boolean active, int available, String category_id, long creation_date,
      int currency, String description, double Price, String title, String user_id) {
    Offer offer = new Offer();
    offer.setActive(active);
    offer.setAvailability(available);
    offer.setCategory_id(category_id);
    offer.setCreation_date(creation_date);
    offer.setCurrency(currency);
    offer.setDescription(description);
    offer.setOffer_id(Integer.toString(offerid++));
    offer.setPrice(Price);
    offer.setTitle(title);
    offer.setUser_id(user_id);
    OFFER_REPO.save(OfferMapper.mapOfferToBackend(offer));
  }

  @RolesAllowed("ADMIN")
  @GET
  @Path("offers")
  public void testCreate100Offers() {
    // 15x babysitten
    createOfferWithArguments(true, 1, "1", 1434442092L, 2,
        "Ich will babysitten, bin 17 Jahre alt, habe 2 Jahre Erfahrung", 15.0, "Babysitten - "
            + "besonders am Wochenende", "user_id1");
    createOfferWithArguments(true, 2, "1", 1434422092L, 2, "Biete professionelles Babysitten, besonders nachts", 15.0,
        "Ich kümmere mich um ihre Kinder!", "user_id2");
    createOfferWithArguments(true, 3, "1", 1434441092L, 2,
        "Babysitte gerne, besonder nachts, kann gut mit Kindern umgehen", 15.0, "Babysitter", "user_id3");
    createOfferWithArguments(true, 0, "1", 1434440092L, 2,
        "Weblicher Babysitter, mache gerade mein Abi und möchte etwas Geld nebenbei dazuverdienen", 20.0,
        "Babysitter, Abiturientin", "user_id4");
    createOfferWithArguments(true, 1, "1", 1434437092L, 2, "Babysitte gerne, keinerlei Erfahrung, lerne schnell", 10.0,
        "Babysitten - sehr günstig", "user_id5");
    createOfferWithArguments(true, 2, "1", 1434439092L, 2, "Biete günstiges Babysitten, auch an Feiertagen", 25.0,
        "Ich kümmere mich um ihre Kinder! ", "user_id6");
    createOfferWithArguments(true, 3, "1", 1434432092L, 2, "Komme aus Furtwangen, Babysitte gerne!", 20.0,
        "Babysitten im Schwarzwald", "user_id7");
    createOfferWithArguments(true, 0, "1", 1434442092L, 2,
        "Habe schon oft für bekannte auf Kinder aufgepasst, möchte nun während der Schulzeit "
            + "ein wenig Geld dazuverdienen, kann sehr gut mit Kindern umgehen", 15.0, "Babysitten", "user_id8");
    createOfferWithArguments(true, 1, "1", 1434422092L, 2, "Babysitten gut Kinder gerne Umgehen ", 15.0,
        "Babysitter gesucht? ich helfe ihnen.", "user_id9");
    createOfferWithArguments(true, 2, "1", 1434429992L, 2,
        "Babysitterin sucht Nebenjob. Habe eine Ausbildung, bin arbeitssuchend", 7.0, "Babysitten", "user_id10");
    createOfferWithArguments(true, 1, "1", 1434442092L, 0,
        "Babysitter ist nicht gleich Babysitter - bei mir sind ihre Kinder Sicher!", 25.0, "Zuverlässiger Babysitter",
        "user_id1");
    createOfferWithArguments(true, 2, "1", 1434422092L, 0,
        "Babysitte alle Kinder. Gebe gerne auch Nachhilfe für die Grundschule!", 15.0, "Babysitting - 0-12 Jahre",
        "user_id2");
    createOfferWithArguments(true, 3, "1", 1434441092L, 0,
        "Babysitten, aber nur nachts, tagsüber bin ich in der schule", 30.0, "Babysitten nachts", "user_id3");
    createOfferWithArguments(true, 0, "1", 1434440092L, 0,
        "Sie wollen in den Urlaub, Ihr Kind hat aber schule? ich kümmer mich um es!", 20.0, "Ferien-Babysitter",
        "user_id4");
    createOfferWithArguments(true, 1, "1", 1434437092L, 0,
        "Samstags und Sonntags passeich gerne auf ihr Kind auf, damit sie Zeit für sich haben", 10.0,
        "Babysitting - Wochenende", "user_id5");

    // 20x Informatik Nachhilfe
    createOfferWithArguments(true, 1, "2", 1434442092L, 0,
        "Gute Programmierkenntnisse in Java, C#, C++, C. Helfe auch gerne bei Praktikumsaufgaben", 25.0,
        "Informatik Nachhilfe geboten", "user_id1");
    createOfferWithArguments(true, 2, "2", 1434422092L, 0,
        "Informatik-Student im 3ten Semester. Biete Programmiernachhilfe!", 15.0,
        "Informatik-Nachhilfe - so bestehst auch du!", "user_id2");
    createOfferWithArguments(true, 3, "2", 1434441092L, 0,
        "Biete hilfe beim Programmieren, gerade bei PHP, JavaScript und HTML!", 30.0, "Informatik ist nicht schwer!",
        "user_id3");
    createOfferWithArguments(true, 0, "2", 1434440092L, 0,
        "Sehr gute Programmierkenntnisse, helfe gerne, besonders bei Grundlagenkursen!", 20.0,
        "Informatik-Grundkurs Nachhilfe", "user_id4");
    createOfferWithArguments(true, 1, "2", 1434437092L, 0,
        "Solide Kentnisse in Java und C! Kann ebenfalls bei Mathe-Problemen helfen!", 10.0,
        "Informatik-Nachhilfe - günstig und effektiv!", "user_id5");
    createOfferWithArguments(true, 2, "2", 1434439092L, 0,
        "Biete Informatik-Nachhilfe, gerade in den Ferien. Am besten mit mehreren Teilnehmern.", 25.0,
        "So schaffst auch du dein Grundstudium! ", "user_id6");
    createOfferWithArguments(
        true,
        3,
        "2",
        1434432092L,
        0,
        "Du studierst Informatik in Furtwangen und hast Probleme bei manchen Programmiersprachen? Dein Studium ist in Gefahr? Ich helfe dir!",
        20.0, "Informatik-Nachhilfe im Schwarzwald", "user_id7");
    createOfferWithArguments(true, 0, "2", 1434442092L, 0,
        "Habe sehr viel Erfahrung mit Nachhilfe und verspreche dir, du wirst bestehen und das besser als 3.0!", 15.0,
        "Informatik-Nachhilfe - Hier bekommst du mehr als nur eine 4!", "user_id8");
    createOfferWithArguments(true, 1, "2", 1434422092L, 0, "Sehr gute Programmierkentnisse, ich helfe gerne!", 15.0,
        "Durch eine Prüfung gefallen? ich helfe ihnen.", "user_id9");
    createOfferWithArguments(
        true,
        2,
        "2",
        1434429992L,
        0,
        "Programmierer sucht Nebenjob. Habe eine Ausbildung, bin arbeitssuchend. Gebe gerne auch Nachhilfe, jedoch nur auf einem hohen Level",
        30.0, "Informatik-Nachhilfe für Profis", "user_id10");
    createOfferWithArguments(true, 1, "2", 1434442092L, 0,
        "Ich biete professionelle Nachhilfe, im Informatik und IT-SicherheitsBereich", 10.0,
        "Informatik Hilfe - Kein Thema!", "user_id1");
    createOfferWithArguments(true, 2, "2", 1434422092L, 0,
        "Ich bin Master-Student in Furtwangen, in Informatik und helfe dir gerne bei deinen Prüfungen", 15.0,
        "So bekommst auch du deinen bachelor mit Links!", "user_id2");
    createOfferWithArguments(
        true,
        3,
        "2",
        1434441092L,
        0,
        "Biete hilfe beim Programmieren, gerade bei PHP, JavaScript und HTML! Habe mich auf Backend-Entwicklung spezialisiert",
        30.0, "Informatik ist einfach zu schaffen!", "user_id3");
    createOfferWithArguments(true, 0, "2", 1434440092L, 0,
        "Ich helfe gerne Beim programmieren, bin besonders gut im Frontend!", 20.0, "Informatik-Frontend Entwicklung",
        "user_id4");
    createOfferWithArguments(true, 1, "2", 1434437092L, 0,
        "Solide Kentnisse in Java und C! Sehr gute Kentnisse in C++ und C#.", 30.0, "Programmiersprachen easygoing!",
        "user_id5");
    createOfferWithArguments(true, 2, "2", 1434439092L, 0, "Praktikumsaufgaben zu schwer? ich mache sie mit dir.",
        25.0, "So wirst du zur Prüfung zugelassen ", "user_id6");
    createOfferWithArguments(true, 3, "2", 1434432092L, 0,
        "Du studierst Informatik in Furtwangen und hast Probleme bei manchen Programmiersprachen? No Problemo!", 20.0,
        "Fuwa Nachhilfe!", "user_id7");
    createOfferWithArguments(true, 0, "2", 1434442092L, 0,
        "Wie schaffst du mit sehr wenig aufwand auch in schwierigen Fächern eine 4? ich zeige es dir!", 15.0,
        "Informatik-Nachhilfe - 4gewinnt!", "user_id8");
    createOfferWithArguments(true, 1, "2", 1434422092L, 0,
        "Sehr gute Programmierkentnisse, helfe gerne, auch bei Semesterprojekten!", 15.0, "Semesterprojekt-Joker",
        "user_id9");
    createOfferWithArguments(true, 2, "2", 1434429992L, 0, "Pr0 programmierer", 30.0, "Informatik-Nachhilfe - Profis",
        "user_id10");

    // 10x Mathe Nachhilfe
    createOfferWithArguments(true, 1, "3", 1434442092L, 0,
        "Mathe Abitur 1.0 - Helfe gerne, dass auch du eine gute Note hast!", 25.0, "Mathe Nachhilfe geboten",
        "user_id1");
    createOfferWithArguments(true, 2, "3", 1434422092L, 0, "Mathe-Student im 3ten Semester. Biete Mathenachhilfe!",
        15.0, "Mathe-Nachhilfe - so bestehst auch du!", "user_id2");
    createOfferWithArguments(true, 3, "3", 1434441092L, 0, "Biete hilfe in Mathematik, gerade Kurvendisskusion!", 30.0,
        "Mathe ist nicht schwer!", "user_id3");
    createOfferWithArguments(true, 0, "3", 1434440092L, 0,
        "Sehr gute Mathematikkentnisse, helfe gerne, besonders bei Grundlagenkursen!", 20.0,
        "Mathe-Grundkurs Nachhilfe", "user_id4");
    createOfferWithArguments(true, 1, "3", 1434437092L, 0,
        "Solide Kentnisse in Mathe und Formale Methoden! Kann ebenfalls bei Formalen Methoden helfen!", 10.0,
        "Mathe-Nachhilfe - günstig und effektiv!", "user_id5");
    createOfferWithArguments(true, 2, "3", 1434439092L, 0,
        "Biete Mathe-Nachhilfe, gerade in den Ferien. Am besten mit mehreren Teilnehmern.", 25.0,
        "So schaffst auch du dein Grundstudium! ", "user_id6");
    createOfferWithArguments(
        true,
        3,
        "3",
        1434432092L,
        0,
        "Du studierst Mathe in Furtwangen und hast Probleme bei manchen Themen? Dein Studium ist in Gefahr? Ich helfe dir!",
        20.0, "Mathe-Nachhilfe im Schwarzwald", "user_id7");
    createOfferWithArguments(true, 0, "3", 1434442092L, 0,
        "Habe sehr viel Erfahrung mit Nachhilfe und verspreche dir, du wirst bestehen und das besser als 3.0!", 15.0,
        "Mathe-Nachhilfe - Hier bekommst du mehr als nur eine 4!", "user_id8");
    createOfferWithArguments(true, 1, "3", 1434422092L, 0, "Sehr gute Mathematikkentnisse, ich helfe gerne!", 15.0,
        "Durch eine Prüfung gefallen? ich helfe ihnen.", "user_id9");
    createOfferWithArguments(true, 2, "3", 1434429992L, 0,
        "Student sucht Nebenjob. Gebe gerne auch Nachhilfe, jedoch nur auf einem hohen Level", 30.0,
        "Mathe-Nachhilfe für Profis", "user_id10");
    // 20x Alten Menschen Helfen
    createOfferWithArguments(true, 1, "4", 1434442092L, 0, "Kleinere Beorgungen, helfe im Haushalt gerne", 25.0,
        "Sie kommen im Alltag nicht zurecht? Ich helfe Ihnen gerne", "user_id1");
    createOfferWithArguments(
        true,
        2,
        "4",
        1434422092L,
        0,
        "Student aus Furtwangen im 3ten Semester. Ich möchte mir eine Kleinigkeit dazu verdienen und einem anderen Menschen den Alltag erleichtern!",
        15.0, "Ich helfe Ihnen beim einkaufen", "user_id2");
    createOfferWithArguments(true, 3, "4", 1434441092L, 0,
        "Ich Helfe Ihnen gerne, bin handwerklich sehr begabt, helfe gerne im Haushalt und bei Gartenarbeiten", 30.0,
        "Haushalt und Gartenarbeit!", "user_id3");
    createOfferWithArguments(true, 0, "4", 1434440092L, 0,
        "Ich kaufe für Sie ein, ich koche, ich kümmere mich um sie!", 20.0,
        "Sie schaffen es nicht alleine? ich bind a!", "user_id4");
    createOfferWithArguments(true, 1, "4", 1434437092L, 0,
        "Ich komme aus Freiburg, ich helfe Ihnen gerne im Haushalt oder laufe mit ihren Haustieren", 10.0,
        "Hunde ausführen!", "user_id5");
    createOfferWithArguments(
        true,
        2,
        "4",
        1434439092L,
        0,
        "Sie gehen für ein paar Wochen in den Urlaub? Kein Problem! ich kümmere mich um ihre Tiere und Pflanzen und halte ihr Haus/Wohnung in Schuss!",
        25.0, "Ferienhilfe! ", "user_id6");
    createOfferWithArguments(
        true,
        3,
        "4",
        1434432092L,
        0,
        "Du schaffst den ganzen Alltag nicht mehr? Der Einkauf ist zu schwer und auch das Treppenlaufen bereitet Mühe? Ich helfe dir!",
        20.0, "Ich helfe Ihnen - Schwarzwald", "user_id7");
    createOfferWithArguments(true, 0, "4", 1434442092L, 0,
        "Ich helfe Ihnen gerne, bin 18 Jahre alt und würde mich gerne um Sie kümmern!", 15.0,
        "Kleine Haushilfe - Ich Lasse sie nicht alleine!", "user_id8");
    createOfferWithArguments(true, 1, "4", 1434422092L, 0, "Iich helfe gerne!", 15.0,
        "Sie fühlen sich einsam und niemand hilft ihnen? ich bin da!", "user_id9");
    createOfferWithArguments(true, 2, "4", 1434429992L, 0,
        "Student sucht Nebenjob. Kann kochen, sauber machen und kleinere Arbeiten erledigen", 30.0, "Ich helfe Ihnen!",
        "user_id10");
    createOfferWithArguments(true, 1, "4", 1434442092L, 0, "Ich räume ihr Haus auf! Der Frühling kommt!", 25.0,
        "Hausputz!", "user_id1");
    createOfferWithArguments(true, 2, "4", 1434422092L, 0,
        "Student aus Furtwangen im 3ten Semester. Bin handwerklich sehr begabt und kann viele Tätigkeiten erledigen",
        15.0, "Ich baue für sie!", "user_id2");
    createOfferWithArguments(true, 3, "4", 1434441092L, 0,
        "Habe einen grünen Daumen und bereits in meiner Freizeit viel gebastelt", 20.0, "Haushalt und Gartenarbeit!",
        "user_id3");
    createOfferWithArguments(true, 0, "4", 1434440092L, 0,
        "Ich kaufe für Sie ein, ich koche, ich helfe ihnen beim umziehen!", 40.0, "Hilfe mit Herz!", "user_id4");
    createOfferWithArguments(true, 1, "4", 1434437092L, 0,
        "Ich kümmere mich um Sie, wenn sie es alleine nicht schaffen!", 10.0, "Sie schaffen es nicht alleine?",
        "user_id5");
    createOfferWithArguments(true, 2, "4", 1434439092L, 0, "Urlaubsvertretung, ich putze Ihr Haus/Wohnung für sie",
        25.0, "Urlaubsvertretung", "user_id6");
    createOfferWithArguments(true, 3, "4", 1434432092L, 0,
        "Der Einkauf ist kaum machbar und das Treppenlaufen bereitet Mühe? Ich helfe Ihnen!", 20.0,
        "Schwarzwaldhilfe!", "user_id7");
    createOfferWithArguments(true, 0, "4", 1434442092L, 0,
        "Ich helfe Ihnen gerne, bin 18 Jahre alt. Kann gut putzen und kochen!", 15.0, "Kleine Haushilfe", "user_id8");
    createOfferWithArguments(true, 1, "4", 1434422092L, 0,
        "Egal bei was. kleinere besorgungen, kochen, putzen, Haustiere versorgen - ich bin da!", 15.0,
        "Ich helfe gerne", "user_id9");
    createOfferWithArguments(true, 2, "4", 1434429992L, 0, "Student sucht Nebenjob. Bin mir für nichts zu schade",
        30.0, "Ich helfe Ihnen -helfen sie mir auch!", "user_id10");

    // 10x Deutsch Nachhilfe
    createOfferWithArguments(true, 1, "5", 1434442092L, 0,
        "Deutsch Abitur 1.0 - Helfe gerne, dass auch du eine gute Note hast!", 25.0, "Deutsch Nachhilfe geboten",
        "user_id1");
    createOfferWithArguments(true, 2, "5", 1434422092L, 0, "Deutsch-Student im 3ten Semester. Biete Deutschnachhilfe!",
        15.0, "Deutsch-Nachhilfe - so bestehst auch du!", "user_id2");
    createOfferWithArguments(true, 3, "5", 1434441092L, 0, "Biete hilfe in Deutsch, Gedichtinterpretation!", 30.0,
        "Deutsch ist nicht schwer!", "user_id3");
    createOfferWithArguments(true, 0, "5", 1434440092L, 0,
        "Sehr gute Deutschkentnisse, helfe gerne, besonders bei Grundlagenkursen!", 20.0,
        "Deutsch-Grundkurs Nachhilfe", "user_id4");
    createOfferWithArguments(true, 1, "5", 1434437092L, 0,
        "Solide Kentnisse in Deutsch und Formale Methoden! Kann ebenfalls bei Formalen Methoden helfen!", 10.0,
        "Deutsch-Nachhilfe - günstig und effektiv!", "user_id5");
    createOfferWithArguments(true, 2, "5", 1434439092L, 0,
        "Biete Deutsch-Nachhilfe, gerade in den Ferien. Am besten mit mehreren Teilnehmern.", 25.0,
        "So schaffst auch du dein Grundstudium! ", "user_id6");
    createOfferWithArguments(
        true,
        3,
        "5",
        1434432092L,
        0,
        "Du machst Abi in Deutsch in Furtwangen und hast Probleme bei manchen Themen? Dein abitur ist in Gefahr? Ich helfe dir!",
        20.0, "Deutsch-Nachhilfe im Schwarzwald", "user_id7");
    createOfferWithArguments(true, 0, "5", 1434442092L, 0,
        "Habe sehr viel Erfahrung mit Nachhilfe und verspreche dir, du wirst bestehen und das besser als 3.0!", 15.0,
        "Deutsch-Nachhilfe - Hier bekommst du mehr als nur eine 4!", "user_id8");
    createOfferWithArguments(true, 1, "5", 1434422092L, 0, "Sehr gute Deutschmatikkentnisse, ich helfe gerne!", 15.0,
        "Durch eine Prüfung gefallen? ich helfe ihnen.", "user_id9");
    createOfferWithArguments(true, 2, "5", 1434429992L, 0,
        "Student sucht Nebenjob. Gebe gerne auch Nachhilfe, jedoch nur auf einem hohen Level", 30.0,
        "Deutsch-Nachhilfe für Profis", "user_id10");

    // 5x Praktikumshilfe
    createOfferWithArguments(true, 1, "6", 1434442092L, 0, "Praktikumsstelle: Sei intressiert und offen!", 25.0,
        "Praktikum Gastronomie", "user_id1");
    createOfferWithArguments(true, 2, "6", 1434422092L, 0,
        "Suche Praktikant für unseren Betrieb. Realschulabschluss empfohlen!", 15.0, "Praktikum Mechatroniker",
        "user_id2");
    createOfferWithArguments(true, 3, "6", 1434441092L, 0, "Ein Praktikum bei der deutschen Post, Zahlen sehr gut!",
        30.0, "Praktikum Deutsche Post", "user_id3");
    createOfferWithArguments(true, 0, "6", 1434440092L, 0,
        "Biete: einen Praktikumsplatz im Gastronomie bereich! Ein offenes, freundliches Team erwartet dich", 20.0,
        "Praktikum", "user_id4");
    createOfferWithArguments(true, 1, "6", 1434437092L, 0, "2 praktikastellen à 3 Wochen zu vergeben!", 10.0,
        "Praktika", "user_id5");

  }

  private void createUserWithArguments(String id, String firstname, String lastname, String zip, String phone) {
    User user = new User();
    user.setId(Integer.toString(userid++));
    user.setUsername(id);
    user.setFirstname(firstname);
    user.setLastname(lastname);
    user.setZip(zip);
    user.setPhone(phone);
    USER_REPO.save(UserMapper.mapUserToBackend(user));
  }

  @RolesAllowed("ADMIN")
  @GET
  @Path("users")
  public void testCreate10Users() {
    createUserWithArguments("user_id1", "Hans", "Meier", "70178", "00497822339");
    createUserWithArguments("user_id2", "Sabrina", "Müller", "77955", "017549302");
    createUserWithArguments("user_id3", "Max", "Mustermann", "70178", "00497222");
    createUserWithArguments("user_id4", "Mannfred", "Muster", "10302", "004917283920");
    createUserWithArguments("user_id5", "Vegan", "Veganon", "70178", "12345678");
    createUserWithArguments("user_id6", "Professor", "Eich", "70178", "00239366");
    createUserWithArguments("user_id7", "Sandy", "Cheeks", "70178", "987665421");
    createUserWithArguments("user_id8", "Spongebob", "Schwammkopf", "12345", "00497822339");
    createUserWithArguments("user_id9", "Patrick", "Star", "70178", "00497822339");
    createUserWithArguments("user_id10", "Thaddäus", "Tentakel", "70178", "00497822339");
  }

  private void createCategoryWithArguments(String category_id, String category_term, int price_6_months_demand,
      int price_12_months_demand, int price_6_months_supply, int price_12_months_supply) {
    Category cat = new Category();
    cat.setCategory_id(category_id);
    cat.setCategory_term(category_term);
    cat.setPrice_6_months_supply(price_6_months_supply);
    cat.setPrice_12_months_supply(price_12_months_supply);
    cat.setPrice_6_months_demand(price_6_months_demand);
    cat.setPrice_12_months_demand(price_12_months_demand);
    CAT_REPO.save(cat);
  }

  @RolesAllowed("ADMIN")
  @GET
  @Path("categories")
  public void createCategoriesForTest() {
    createCategoryWithArguments("0", "Mentoring", 0, 0, 0, 0);
    createCategoryWithArguments("1", "Nachhilfe", 1900, 2900, 900, 1900);
    createCategoryWithArguments("2", "Entruempelung/ Umzugshilfe/ Gartenhilfe", 1900, 2900, 900, 1900);
    createCategoryWithArguments("3", "Uebersetzungen", 2900, 3900, 3900, 4900);
    createCategoryWithArguments("4", "Grafikdesign", 2900, 3900, 3900, 4900);
    createCategoryWithArguments("5", "Programmieren", 3900, 4900, 8900, 9900);
    createCategoryWithArguments("6", "Praktikum/ Thesis", 3900, 4900, 15000, 25000);
    createCategoryWithArguments("7", "Ferienjob (6-8 Wochen)", 3900, 4900, 15000, 25000);
    createCategoryWithArguments("8", "Festanstellung", 3900, 4900, 29000, 39000);
  }

  @RolesAllowed("ADMIN")
  @GET
  @Path("delete")
  public void deleteTestData() {
    userid=0;
    offerid=0;
    for (int i = 0; i < 10; i++) {
      USER_REPO.deleteByID(UserMongo.class, Integer.toString(i));
    }
    for (int i = 0; i < 150; i++) {
      USER_REPO.deleteByID(OfferMongo.class, Integer.toString(i));
    }
  }

}
