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
      this.phone = phone; 
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) { //Valid Email
    this.email = email;
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