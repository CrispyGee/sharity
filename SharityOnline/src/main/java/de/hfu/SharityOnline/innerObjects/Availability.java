package de.hfu.SharityOnline.innerObjects;

public enum Availability {
  
  vollzeit(0), teilzeit(1), minijob(2), stundenbasiert(3);

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
