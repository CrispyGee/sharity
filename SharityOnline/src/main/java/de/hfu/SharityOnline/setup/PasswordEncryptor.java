package de.hfu.SharityOnline.setup;

import java.security.MessageDigest;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordEncryptor {

  private static final StrongPasswordEncryptor ENCRYPTOR = new StrongPasswordEncryptor();

  public static StrongPasswordEncryptor getEncryptor() {
    return ENCRYPTOR;
  }
  
  public static String encodePassword(String passwort) throws Exception  {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    md5.reset();
    md5.update(passwort.getBytes());
    byte[] result = md5.digest();
    StringBuffer hexString = new StringBuffer();
    for (int i=0; i<result.length; i++) {
        hexString.append(Integer.toHexString(0xFF & result[i]));
    }
    return hexString.toString();
  }

}
