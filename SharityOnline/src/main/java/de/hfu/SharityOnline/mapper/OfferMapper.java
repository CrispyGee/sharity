package de.hfu.SharityOnline.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import de.hfu.SharityOnline.frontend.entities.Offer;
import de.hfu.SharityOnline.innerObjects.Activity;
import de.hfu.SharityOnline.innerObjects.Salutation;
import de.hfu.SharityOnline.mongo.OfferMongo;

public class OfferMapper {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();
  // private static boolean toFront = true;
  static {
    MODEL_MAPPER.addMappings(new OfferToFrontendProps());
    MODEL_MAPPER.addMappings(new OfferToBackendProps());
  }

  public static Offer mapOfferToFrontend(OfferMongo offerMongo) {
    Offer offer = MODEL_MAPPER.map(offerMongo, Offer.class);
    offer.setCategory_id(offerMongo.getCategory().getCategory_id());
    offer.setAvailability(offerMongo.getAvailability().getNumber());
    return offer;
  }

  public static OfferMongo mapOfferToBackend(Offer offer) {
    OfferMongo offerMongo = MODEL_MAPPER.map(offer, OfferMongo.class);
    offerMongo.setSalutation(Salutation.fromNumber(offer.getSalutation()));
//    offerMongo.setActivity(Activity.fromNumber(offer.getActivity()));
    return offerMongo;
  }

  public static List<Offer> mapOfferListToFrontend(List<OfferMongo> offerMongoList) {
    List<Offer> offerList = new ArrayList<>();
    for (OfferMongo offerMongo : offerMongoList) {
      offerList.add(mapOfferToFrontend(offerMongo));
    }
    return offerList;
  }

  public static List<OfferMongo> mapOfferListToBackend(List<Offer> offerList) {
    List<OfferMongo> offerMongoList = new ArrayList<>();
    for (Offer offer : offerList) {
      offerMongoList.add(mapOfferToBackend(offer));
    }
    return offerMongoList;
  }

}

class OfferToFrontendProps extends PropertyMap<OfferMongo, Offer> {
  @Override
  protected void configure() {
//    skip().setActivity(0);
//    skip().setSalutation(0);
  }
}

class OfferToBackendProps extends PropertyMap<Offer, OfferMongo> {
  @Override
  protected void configure() {
//    skip().setActivity(null);
//    skip().setSalutation(null);
  }
}
