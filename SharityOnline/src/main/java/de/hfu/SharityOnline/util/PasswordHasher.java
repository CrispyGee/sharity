package de.hfu.SharityOnline.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordHasher {

  
  private static final StrongPasswordEncryptor ENCRYPTOR = new StrongPasswordEncryptor();

  
  public static String md5(String input) {
    if (input == null) {
      return null;
    }
    String md5 = null;
    try {
      // Create MessageDigest object for MD5
      MessageDigest digest = MessageDigest.getInstance("MD5");
      // Update input string in message digest
      digest.update(input.getBytes(), 0, input.length());
      // Converts message digest value in base 16 (hex)
      md5 = new BigInteger(1, digest.digest()).toString(32);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return md5;
  }


  public static StrongPasswordEncryptor getEncryptor() {
    return ENCRYPTOR;
  }

}
