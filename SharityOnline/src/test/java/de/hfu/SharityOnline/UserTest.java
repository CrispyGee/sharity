package de.hfu.SharityOnline;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.rest.UserRestSchnittstelle;

public class UserTest {
  public static UserRestSchnittstelle u = new UserRestSchnittstelle();
  private static String id = "1";
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  
  public User createUser() {
    incID();
    User u = new User();
    u.setUsername(getId());
    u.setFirstname("Mannfred");
    u.setLastname("Mustermann");
    u.setZip("77955");
    u.setPhone("012346758");
    return u;
  }
  public void incID() {
   int i = Integer.parseInt(getId());
   i++;
  setId(Integer.toString(i));
}
  /*
   * Username- Tests
   */
  @Test
  public void testUserName_zuLange() {  
    User user = createUser();
    user.setUsername("Muuuuuuuuuuuuuuuuuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testUserName_zuKurz() {
    User user = createUser();
    user.setUsername("");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  public void testUserName_valid() {
    User user = createUser();
    user.setUsername("d3ir4");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   *  Nachname - Tests
   */
  @Test
  public void testVornameUser_mitZahlen() {
    User user = createUser();
    user.setFirstname("M3n4");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testNachnameUser_zuLang() {
    User user = createUser();
    user.setLastname("Muuuuuuuuuuuuuuuuuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testNachnameUser_zuKurz() {
    User user = createUser();
    user.setLastname("");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testNachnameUser_valid() {
    User user = createUser();
    user.setLastname("Mustermann");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   * Vorname- Test
   */
  @Test
  public void testNachnameUser_mitZahlen() {
    User user = createUser();
    user.setLastname("M3n4");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testVorname_zuLang() {
    User user = createUser();
    user.setFirstname("Muuuuuuuuuuuuuuuuuuusdsduuuuuuuuustermaaaaaaaaaaaaannn");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testVornameUser_zuKurz() {
    User user = createUser();
    user.setFirstname("");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testVornameUser_valid() {
    User user = createUser();
    user.setFirstname("Mustermann");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   * Zip - Tests
   */
  
  @Test
  public void testZipWithChar() {
    User user = createUser();
    user.setZip("779EE");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testZip_zuLange() {
    User user = createUser();
    user.setZip("779554");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testZip_zuKurz() {
    User user = createUser();
    user.setZip("779");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testZip_valid() {  
    User user = createUser();
      user.setZip("77955");
      Response r = u.createEntity(user);
      assertTrue(r.getStatus() == 200);
  }
  /*
   * Hometown - Tests
   */
  @Test
  public void testHometown_mitZahlen() {
    User user = createUser();
    user.setHometown("Furtwangen42");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testHometown_zuLang() {
    User user = createUser();
    user.setHometown("Furtwaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaangen");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testHometown_valid() {
    User user = createUser();
    user.setHometown("Furtwangen");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   * Birthday - Tests
   */
  @Test
  public void testBirthday_zuLang() {
    User user = createUser();
      user.setBirthday(11111111112222111L);
      Response r = u.createEntity(user);
      assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testBirthday_valid() {
    User user = createUser();
    user.setBirthday(1234567891L);
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   * Phone - Tests
   */
  @Test
  public void testPhone_zuLang() {
    User user = createUser();
      user.setPhone("99999999999999999999912122323434343434343434343434343434343434343434433434343499999999999999999999999999");
      Response r = u.createEntity(user);
      assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testPhone_mitBuchstaben() {
    User user = createUser();
    user.setPhone("123456Lol");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 400);
  }
  @Test
  public void testPhone_valid() {
    User user = createUser();
    user.setPhone("0049782289123");
    Response r = u.createEntity(user);
    assertTrue(r.getStatus() == 200);
  }
  /*
   * Email- Tests
   */
  //TODO:

}