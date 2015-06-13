package de.hfu.SharityOnline.innerObjects;

public enum Activity {
  
  student(0), schueler(1), arbeitend(2), arbeitslos(3), rentner(4);

  int number;
  
  Activity(int number){
    this.number=number;
  }
  
  public int getNumber(){
    return this.number;
  }
  
  public static Activity fromNumber(int number) {
    for (Activity activity : Activity.values()) {
      if (activity.getNumber() == number)
        return activity;
    }
    return null;
  }
  
}
