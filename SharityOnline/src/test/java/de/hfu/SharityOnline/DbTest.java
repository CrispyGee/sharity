package de.hfu.SharityOnline;

import org.junit.Ignore;
import org.junit.Test;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.entities.Page;
import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.innerObjects.EmployedInfo;
import de.hfu.SharityOnline.innerObjects.PupilInfo;
import de.hfu.SharityOnline.innerObjects.StudentInfo;
import de.hfu.SharityOnline.mapper.OfferMapper;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.setup.PasswordEncryptor;
import de.hfu.SharityOnline.setup.Repository;
import de.hfu.SharityOnline.setup.TimeHelper;

@Ignore
public class DbTest {

  private static final Repository<UserMongo> userRepo = new Repository<UserMongo>();
  private static final Repository<OfferMongo> offerRepo = new Repository<OfferMongo>();
  private static final Repository<Category> catRepo = new Repository<Category>();
  private static final Repository<Page> pageRepo = new Repository<Page>();

  @Test
  public void fillDatabaseWithLegitData() throws Exception {
    createPages();
    createCategories();
    createNormalFreeUsers();
    createAdminUser();
    createSomeOffers();
  }

  /**
   * Use to delete Db content
   */
  // @AfterClass
  // public static void clearDbUp() {
  // userRepo.dropCollection(UserMongo.class);
  // offerRepo.dropCollection(OfferMongo.class);
  // catRepo.dropCollection(Category.class);
  // pageRepo.dropCollection(Page.class);
  // }

  private void createCategories() {
    Category category1 = new Category();
    category1.setCategory_id("cat_id1");
    category1.setCategory_term("Gartenarbeit");
//    category1.setPrice_12_months(900);
    Category category2 = new Category();
    category2.setCategory_id("cat_id2");
    category2.setCategory_term("Nachhilfe");
//    category2.setPrice_12_months(1200);
    Category category3 = new Category();
    category3.setCategory_id("cat_id3");
//    category3.setPrice_12_months(1500);
    category3.setCategory_term("Programmieren");
    Category category4 = new Category();
    category4.setCategory_id("cat_id4");
//    category4.setPrice_12_months(2000);
    category4.setCategory_term("Praktikum");
    catRepo.save(category1);
    catRepo.save(category2);
    catRepo.save(category3);
    catRepo.save(category4);
  }

  private void createPages() {
    Page page1 = new Page();
    page1.setId("page1");
    page1.setMain_content("maaaain_coooonteeent");
    page1.setMeta_description("sooo meeetaaa");
    page1.setMeta_keywords("SEO SEO SEO SEO");
    Page page2 = new Page();
    page2.setId("page2");
    page2.setMain_content("maaaain_coooonteeent");
    page2.setMeta_description("sooo meeetaaa");
    page2.setMeta_keywords("SEO SEO SEO SEO");
    pageRepo.save(page1);
    pageRepo.save(page2);
  }

  private void createAdminUser() throws Exception {
    User user = new User();
    user.setId("ChrisSoph");
    user.setUserRole("ADMIN");
    user.setLastname("Chris");
    user.setFirstname("Soph");
    user.setPassword(PasswordEncryptor.encodePassword("sharity!rest"));
    user.setUsername("Admin");
    user.setSalutation(1);
    user.setActivity(0);
    userRepo.save(UserMapper.mapUserToBackend(user));

  }

  private void createNormalFreeUsers() {
    User user = new User();
    user.setId("1");
    user.setLastname("Mustermann");
    user.setFirstname("Max");
    user.setUserRole("FREE");
    user.setPassword("123");
    user.setUsername("maxi_musti");
    user.setBirthday(System.currentTimeMillis());
    user.setSalutation(1);
    user.setSelfportrait("Ich bin ein Beispielinhalt namens Max Mustermann.");
    user.setEmail("max@mustermann.de");
    user.setZip("77955");
    user.setPhone("078228942");
    user.setHometown("Ettenheim");
    EmployedInfo employed_info1 = new EmployedInfo();
    employed_info1.setProfession("profession");
    user.setEmployed_info(employed_info1);
    user.setActivity(1);
    userRepo.save(UserMapper.mapUserToBackend(user));
    User user2 = new User();
    user2.setId("2");
    user2.setLastname("Müller");
    user2.setFirstname("Horst");
    user2.setSalutation(1);
    user2.setActivity(2);
    user2.setSelfportrait("Spinnenmann");
    user2.setEmail("müllerhorst@mustermann.de");
    user2.setZip("12345");
    user2.setPhone("0007822");
    user2.setHometown("Furtwangen");
    user2.setUsername("horstimülli");
    StudentInfo studentInfo = new StudentInfo();
    user2.setStudent_info(studentInfo);
    userRepo.save(UserMapper.mapUserToBackend(user2));
    User user3 = new User();
    user3.setId("3");
    user3.setLastname("Meyer");
    user3.setFirstname("Gabi");
    user3.setSalutation(1);
    user3.setActivity(2);
    user3.setSelfportrait("Cake Toppings");
    user3.setEmail("gabi@meyer.de");
    user3.setZip("79100");
    user3.setPhone("0007822");
    user3.setHometown("Freiburg");
    user3.setUsername("gabigab");
    PupilInfo pupilInfo = new PupilInfo();
    user3.setPupil_info(pupilInfo);
    userRepo.save(UserMapper.mapUserToBackend(user3));
  }

  private void createSomeOffers() {
    Offer offer1 = new Offer();
    offer1.setOffer_id("off_id1");
    offer1.setActive(true);
    offer1.setAvailability(0);
    offer1.setCurrency(0);
    offer1.setDescription("Gassi gehen mit Hund, gerne auch täglich, ohne Bezahlung");
    offer1.setPrice(100.0d);
    offer1.setCreation_date(System.currentTimeMillis() - 7 * TimeHelper.MONTH_IN_MILLIS);
    offer1.setTitle("Hund ausführen");
    offer1.setCategory_id("cat_id1");
    offer1.setUser_id("1");
    offer1.setOffer_duration(0);
    Offer offer2 = new Offer();
    offer2.setOffer_id("off_id2");
    offer2.setActive(true);
    offer2.setAvailability(1);
    offer2.setCurrency(0);
    offer2.setDescription("Gartenarbeit für 10 euro die stunde!");
    offer2.setPrice(50.0d);
    offer2.setCreation_date(System.currentTimeMillis() - 7 * TimeHelper.MONTH_IN_MILLIS);
    offer2.setTitle("Gartenarbeit");
    offer2.setCategory_id("cat_id2");
    offer2.setUser_id("1");
    offer2.setOffer_duration(1);
    Offer offer3 = new Offer();
    offer3.setOffer_id("off_id3");
    offer3.setActive(true);
    offer3.setAvailability(2);
    offer3.setCurrency(0);
    offer3.setDescription("Biete Nachhilfe in Informatik");
    offer3.setPrice(25.0d);
    offer3.setTitle("Mathe Nachhilfe");
    offer3.setCategory_id("cat_id3");
    offer3.setUser_id("2");
    offer3.setOffer_duration(1);
    offer3.setCreation_date(System.currentTimeMillis() - 13 * TimeHelper.MONTH_IN_MILLIS);
    Offer offer4 = new Offer();
    offer4.setOffer_id("off_id4");
    offer4.setActive(false);
    offer4.setAvailability(3);
    offer4.setCurrency(0);
    offer4.setDescription("Babysitte gerne, habe viel Erfahrung, von 2 bis 12 Jahren!");
    offer4.setPrice(75.0d);
    offer4.setTitle("Babysitten geboten!");
    offer4.setCategory_id("cat_id4");
    offer4.setUser_id("2");
    offerRepo.save(OfferMapper.mapOfferToBackend(offer1));
    offerRepo.save(OfferMapper.mapOfferToBackend(offer2));
    offerRepo.save(OfferMapper.mapOfferToBackend(offer3));
    offerRepo.save(OfferMapper.mapOfferToBackend(offer4));
  }
}
