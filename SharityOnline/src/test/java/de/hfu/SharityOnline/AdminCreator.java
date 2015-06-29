package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.mapper.UserMapper;
import de.hfu.SharityOnline.setup.PasswordEncryptor;
import de.hfu.SharityOnline.setup.Repository;

public class AdminCreator {

  private static final Repository<UserMongo> userRepo = new Repository<UserMongo>();

  @Test
  public void createAdminUser() throws Exception {
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

}
