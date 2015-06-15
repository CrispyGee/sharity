package de.hfu.SharityOnline.polling;

import java.util.List;

import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.setup.Repository;

public class InactiveOfferRunnable implements Runnable {

  private static final Repository<OfferMongo> repository = new Repository<OfferMongo>();

  @Override
  public void run() {
    List<OfferMongo> offersList = repository.loadOffersOlderThan6Months();
    for (OfferMongo offerMongo : offersList) {
      offerMongo.setActive(false);
      repository.save(offerMongo);
    }
    List<OfferMongo> offersList2 = repository.loadOffersOlderThan12Months();
    for (OfferMongo offerMongo : offersList2) {
      offerMongo.setActive(false);
      repository.save(offerMongo);
    }

  }

}
