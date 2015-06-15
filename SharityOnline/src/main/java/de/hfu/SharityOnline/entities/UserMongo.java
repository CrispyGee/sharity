package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import de.hfu.SharityOnline.innerObjects.Activity;
import de.hfu.SharityOnline.innerObjects.EmployedInfo;
import de.hfu.SharityOnline.innerObjects.PupilInfo;
import de.hfu.SharityOnline.innerObjects.Salutation;
import de.hfu.SharityOnline.innerObjects.StudentInfo;

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
  private String usernameAndPassword;
  private String userRole;
  private Salutation salutation;
  private String lastname;
  private String firstname;
  private String zip;
  private String hometown;
  private long birthday;
  private String phone;
  @Indexed(unique = true)
  private String email;
  private Activity activity;
  private StudentInfo student_info;
  private PupilInfo pupil_info;
  private EmployedInfo employed_info;
  private String references_experiences;
  private String selfportrait;
  private long creation_date;
  
  public long getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(long creation_date) {
    this.creation_date = creation_date;
  }
  
  
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
  public String getUsernameAndPassword() {
    return usernameAndPassword;
  }
  public void setUsernameAndPassword(String usernameAndPassword) {
    this.usernameAndPassword = usernameAndPassword;
  }

  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "UserMongo [id=" + id + ", username=" + username + ", password=" + password + ", usernameAndPassword="
        + usernameAndPassword + ", userRole=" + userRole + ", salutation=" + salutation + ", lastname=" + lastname
        + ", firstname=" + firstname + ", zip=" + zip + ", hometown=" + hometown + ", birthday=" + birthday
        + ", phone=" + phone + ", email=" + email + ", activity=" + activity + ", references_experiences="
        + references_experiences + ", selfportrait=" + selfportrait + ", creation_date=" + creation_date + "]";
  }

  public StudentInfo getStudent_info() {
    return student_info;
  }

  public void setStudent_info(StudentInfo student_info) {
    this.student_info = student_info;
  }

  public PupilInfo getPupil_info() {
    return pupil_info;
  }

  public void setPupil_info(PupilInfo pupil_info) {
    this.pupil_info = pupil_info;
  }

  public EmployedInfo getEmployed_info() {
    return employed_info;
  }

  public void setEmployed_info(EmployedInfo employed_info) {
    this.employed_info = employed_info;
  }
  
}
