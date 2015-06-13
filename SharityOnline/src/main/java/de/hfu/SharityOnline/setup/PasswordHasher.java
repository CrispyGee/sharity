package de.hfu.SharityOnline.setup;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordHasher {

  private static final StrongPasswordEncryptor ENCRYPTOR = new StrongPasswordEncryptor();

  public static StrongPasswordEncryptor getEncryptor() {
    return ENCRYPTOR;
  }

}
