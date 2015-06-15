package de.hfu.SharityOnline.innerObjects;

public enum OfferDuration {

  SECHS_MONATE(0), ZWOELF_MONATE(1);
  
  int number;
  
  OfferDuration(int number){
    this.number=number;
  }
  
  public int getNumber(){
    return this.number;
  }
  
  public static OfferDuration fromNumber(int number) {
    for (OfferDuration duration : OfferDuration.values()) {
      if (duration.getNumber() == number)
        return duration;
    }
    return null;
  }
}
