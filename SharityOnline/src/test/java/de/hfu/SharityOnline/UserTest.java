package de.hfu.SharityOnline;

import junit.framework.Assert;

import org.junit.Test;

import de.hfu.SharityOnline.entities.User;

public class UserTest {

  /*
   * Username- Tests
   */
  @Test
  public void testUserName_zuLange() {
    boolean bool = false;
    User user = new User();
    try {
    user.setUsername("Muuuuuuuuuuuuuuuuuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testUserName_zuKurz() {
    boolean bool = false;
    User user = new User();
    try {
    user.setUsername("");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  public void testUserName_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setUsername("d3ir4");
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   *  Nachname - Tests
   */
  @Test
  public void testVornameUser_mitZahlen() {
    boolean bool = false;
    User user = new User();
    try {
    user.setFirstname("M3n4");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testNachnameUser_zuLang() {
    boolean bool = false;
    User user = new User();
    try {
    user.setLastname("Muuuuuuuuuuuuuuuuuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testNachnameUser_zuKurz() {
    boolean bool = false;
    User user = new User();
    try {
    user.setLastname("n");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testNachnameUser_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setLastname("Mustermann");
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   * Vorname- Test
   */
  @Test
  public void testNachnameUser_mitZahlen() {
    boolean bool = false;
    User user = new User();
    try {
    user.setLastname("M3n4");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testVorname_zuLang() {
    boolean bool = false;
    User user = new User();
    try {
    user.setFirstname("Muuuuuuuuuuuuuuuuuuuuuuuuuuuustermaaaaaaaaaaaaannn");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testVornameUser_zuKurz() {
    boolean bool = false;
    User user = new User();
    try {
    user.setFirstname("n");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testVornameUser_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setFirstname("Mustermann");
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   * Zip - Tests
   */
  
  @Test
  public void testZipWithChar() {
    boolean bool = false;
    User user = new User();
    try {
    user.setZip("779EE");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testZip_zuLange() { 
    boolean bool = false;
    User user = new User();
    try {
    user.setZip("779554");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testZip_zuKurz() {
    boolean bool = false;
    User user = new User();
    try {
    user.setZip("779");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testZip_valid() {
    boolean bool = true;
    User user = new User();
    try {
      user.setZip("77955");
    } catch(IllegalArgumentException e) {
      bool = false;
    }
    Assert.assertTrue(bool);
  }
  /*
   * Hometown - Tests
   */
  @Test
  public void testHometown_mitZahlen() {
    boolean bool = false;
    User user = new User();
    try {
    user.setHometown("Furtwangen42");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testHometown_zuLang() {
    boolean bool = false;
    User user = new User();
    try {
    user.setHometown("Furtwaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaangen");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testHometown_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setHometown("Furtwangen");
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   * Birthday - Tests
   */
  @Test
  public void testBirthday_zuLang() {
    boolean bool = false;
    User user = new User();
    try {
      user.setBirthday(11111111112222111L);
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testBirthday_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setBirthday(1234567891L);
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   * Phone - Tests
   */
  @Test
  public void testPhone_zuLang() {
    boolean bool = false;
    User user = new User();
    try {
      user.setPhone("99999999999999999999999999999999999999999999999");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testPhone_mitBuchstaben() {
    boolean bool = false;
    User user = new User();
    try {
    user.setPhone("123456Lol");
    } catch(IllegalArgumentException e) {
      bool = true; 
    }
    Assert.assertTrue(bool);
  }
  @Test
  public void testPhone_valid() {
    boolean bool = true;
    User user = new User();
    try {
    user.setPhone("0049782289123");
    } catch(IllegalArgumentException e) {
      bool = false; 
    }
    Assert.assertTrue(bool);
  }
  /*
   * Email- Tests
   */
  //TODO:

}