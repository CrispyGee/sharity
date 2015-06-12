package de.hfu.SharityOnline.mongo;

import java.io.Serializable;
import java.util.Calendar;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity("users")
public class UserMongo implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  private String id;
  @Indexed(unique = true)
  private String username;
  private String password;
  private String userRole;
  private Salutation salutation;
  private String lastname;
  private String firstname;
  private String zip;
  private String hometown;
  private Calendar birthday;
  private String phone;
  @Indexed(unique = true)
  private String email;
  private Activity activity;
  private String references_experiences;
  private String selfportrait;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getUserRole() {
    return userRole;
  }
  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
  public Salutation getSalutation() {
    return salutation;
  }
  public void setSalutation(Salutation salutation) {
    this.salutation = salutation;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
  public String getHometown() {
    return hometown;
  }
  public void setHometown(String hometown) {
    this.hometown = hometown;
  }
  public Calendar getBirthday() {
    return birthday;
  }
  public void setBirthday(Calendar birthday) {
    this.birthday = birthday;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Activity getActivity() {
    return activity;
  }
  public void setActivity(Activity activity) {
    this.activity = activity;
  }
  public String getReferences_experiences() {
    return references_experiences;
  }
  public void setReferences_experiences(String references_experiences) {
    this.references_experiences = references_experiences;
  }
  public String getSelfportrait() {
    return selfportrait;
  }
  public void setSelfportrait(String selfportrait) {
    this.selfportrait = selfportrait;
  }
  
}
