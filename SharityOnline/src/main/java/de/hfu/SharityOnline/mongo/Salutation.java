package de.hfu.SharityOnline.mongo;

public enum Salutation {

  weiblich(0), maennlich(1);

  int number;

  Salutation(int number) {
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  public static Salutation fromNumber(int number) {
    for (Salutation sal : Salutation.values()) {
      if (sal.getNumber() == number)
        return sal;
    }
    return null;
  }

}
