package de.hfu.SharityOnline.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import de.hfu.SharityOnline.entities.User;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.innerObjects.Activity;
import de.hfu.SharityOnline.innerObjects.Salutation;

public class UserMapper {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();
  // private static boolean toFront = true;
  static {
    MODEL_MAPPER.addMappings(new UserToFrontendProps());
    MODEL_MAPPER.addMappings(new ToBackendProps());
  }

  public static User mapUserToFrontend(UserMongo userMongo) {
    User user = MODEL_MAPPER.map(userMongo, User.class);
    user.setActivity(userMongo.getActivity().getNumber());
    user.setSalutation(userMongo.getSalutation().getNumber());
    return user;
  }

  public static UserMongo mapUserToBackend(User user) {
    UserMongo userMongo = MODEL_MAPPER.map(user, UserMongo.class);
    userMongo.setSalutation(Salutation.fromNumber(user.getSalutation()));
    userMongo.setActivity(Activity.fromNumber(user.getActivity()));
    return userMongo;
  }

  public static List<User> mapUserListToFrontend(List<UserMongo> userMongoList) {
    List<User> userList = new ArrayList<>();
    for (UserMongo userMongo : userMongoList) {
      userList.add(mapUserToFrontend(userMongo));
    }
    return userList;
  }

  public static List<UserMongo> mapUserListToBackend(List<User> userList) {
    List<UserMongo> userMongoList = new ArrayList<>();
    for (User user : userList) {
      userMongoList.add(mapUserToBackend(user));
    }
    return userMongoList;
  }

}

class UserToFrontendProps extends PropertyMap<UserMongo, User> {
  @Override
  protected void configure() {
    skip().setActivity(0);
    skip().setSalutation(0);
  }
}

class ToBackendProps extends PropertyMap<User, UserMongo> {
  @Override
  protected void configure() {
    skip().setActivity(null);
    skip().setSalutation(null);
  }
}
