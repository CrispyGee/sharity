package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.frontend.entities.User;
import de.hfu.SharityOnline.setup.Repository;

public class DbConnectionTest {


  @Test
  public void testDummyDatenprofil() {
    Repository<User> rep = new Repository<User>();
    User user = new User();
    user.setId("blaaaah");
    rep.save(user);
    System.out.println(rep.loadById(User.class, "blaaaah"));
    rep.deleteByID(User.class, "blaaaah");
  }

}
