package de.hfu.SharityOnline.innerObjects;

public enum Availability {
  
  student(0), schueler(1), arbeitend(2), arbeitslos(3), rentner(4);

  int number;
  
  Availability(int number){
    this.number=number;
  }
  
  public int getNumber(){
    return this.number;
  }
  
  public static Availability fromNumber(int number) {
    for (Availability activity : Availability.values()) {
      if (activity.getNumber() == number)
        return activity;
    }
    return null;
  }
  
}
