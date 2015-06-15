package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.polling.InactiveOfferRunnable;

public class InactiveOffersTest {

  @Test
  public void inactiveOffersTest() {
    InactiveOfferRunnable inactiveOfferRunnable = new InactiveOfferRunnable();
    inactiveOfferRunnable.run();
  }

}
