package de.hfu.SharityOnline.entities;

import de.hfu.SharityOnline.innerObjects.EmployedInfo;
import de.hfu.SharityOnline.innerObjects.PupilInfo;
import de.hfu.SharityOnline.innerObjects.StudentInfo;



public class User{

  private String id;
  private String username;
  private String password;
  private String userRole;
  private int salutation;
  private String lastname;
  private String firstname;
  private String zip;
  private String hometown;
  private long birthday;
  private String phone;
  private String email;
  private int activity;
  private StudentInfo student_info;
  private PupilInfo pupil_info;
  private EmployedInfo employed_info;
  private String references_experiences;
  private String selfportrait;
  private long creation_date;

  public User() {
    this.creation_date = System.currentTimeMillis();
  }

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
    if(max_Char(username, 20) && username.length() >= 1) {
    this.username = username;
    } else {
      throw new IllegalArgumentException();
    }
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

  public int getSalutation() {
    return salutation;
  }

  public void setSalutation(int salutation) {
    this.salutation = salutation;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    if(max_Char(lastname, 15) && !hasNumbers(lastname) && lastname.length() > 1) {
      this.lastname = lastname;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    if(max_Char(firstname, 15) && !hasNumbers(firstname) && firstname.length() > 1) {
      this.firstname = firstname;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    if(exact_Char(zip, 5) && onlyNumbers(zip)) {
      this.zip = zip;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public String getHometown() {
    return hometown;
  }

  public void setHometown(String hometown) {
    if(max_Char(hometown, 15) && !hasNumbers(hometown)) {
      this.hometown = hometown;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
   // if(birthday == 10) {
      this.birthday = birthday;
  //  } else {
  //    throw new IllegalArgumentException();
  //TODO:  }
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    if(max_Char(phone, 30) && onlyNumbers(phone)) {
      this.phone = phone; 
    } else {
      throw new IllegalArgumentException();
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) { //Valid Email
//    boolean isValid = false;
//    try {
//      InternetAddress emailAddr = new InternetAddress(email);
//      emailAddr.validate();
//      isValid = true;
//    } catch (AddressException e) {
//      throw new IllegalArgumentException();
//    }
//    if( isValid) {
    this.email = email;
//    } else {
//      throw new IllegalArgumentException();
//    }
  }

  public int getActivity() {
    return activity;
  }

  public void setActivity(int activity) {
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
  
  public boolean hasNumbers(String s) {
    boolean hasNumbers = false;
    for (int i = 0; i < s.length(); i++) {
        if(Character.isDigit(s.charAt(i))) {
          hasNumbers = true;
        }
    }
    return hasNumbers;
  }
  
  public boolean onlyNumbers(String s) {
    boolean bool = true;
    for (int i = 0; i < s.length(); i++) {
      if(!Character.isDigit(s.charAt(i))) {
        bool = false;
      }
    }
    return bool;
  }
  
  
  public boolean max_Char(String s, int size) {
    if (s.length() <= size) {
        return true;
    }
    return false;
  }
  public boolean exact_Char(String s, int size) {
    if (s.length() == size) {
      return true;
    }
    return false;
  }
//TODO activity zeug

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
