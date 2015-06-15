package de.hfu.SharityOnline.polling;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OffersPolling {

  public static void startPolling() {
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
    scheduledThreadPoolExecutor.scheduleAtFixedRate(new InactiveOfferRunnable(), 0, 24, TimeUnit.HOURS);
  }

}
