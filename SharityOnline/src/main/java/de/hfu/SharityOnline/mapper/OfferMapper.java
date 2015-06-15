package de.hfu.SharityOnline.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.Offer;
import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.innerObjects.Availability;
import de.hfu.SharityOnline.innerObjects.OfferDuration;
import de.hfu.SharityOnline.setup.Repository;

public class OfferMapper {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();
  private static final Repository<Category> categoryRepo = new Repository<Category>();
  private static final Repository<UserMongo> userRepo = new Repository<UserMongo>();

  // private static boolean toFront = true;
  static {
    MODEL_MAPPER.addMappings(new OfferToFrontendProps());
    MODEL_MAPPER.addMappings(new OfferToBackendProps());
  }

  public static Offer mapOfferToFrontend(OfferMongo offerMongo) {
    Offer offer = MODEL_MAPPER.map(offerMongo, Offer.class);
    offer.setCategory_id(offerMongo.getCategory().getCategory_id());
    offer.setAvailability(offerMongo.getAvailability().getNumber());
    if (offerMongo.getUserMongo() != null) {
      offer.setUser_id(offerMongo.getUserMongo().getId());
    }
    offer.setOffer_duration(offerMongo.getOfferDuration().getNumber());
    return offer;
  }

  public static OfferMongo mapOfferToBackend(Offer offer) {
    OfferMongo offerMongo = MODEL_MAPPER.map(offer, OfferMongo.class);
    Category category = categoryRepo.loadByKey(Category.class, "category_id", offer.getCategory_id());
    offerMongo.setCategory(category);
    UserMongo userMongo = userRepo.loadById(UserMongo.class, offer.getUser_id());
    offerMongo.setUserMongo(userMongo);
    offerMongo.setAvailability(Availability.fromNumber(offer.getAvailability()));
    offerMongo.setOfferDuration(OfferDuration.fromNumber(offer.getOffer_duration()));
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
    skip().setCategory_id(null);
    skip().setAvailability(0);
    skip().setUser_id(null);
    skip().setOffer_duration(0);
  }
}

class OfferToBackendProps extends PropertyMap<Offer, OfferMongo> {
  @Override
  protected void configure() {
    skip().setCategory(null);
    skip().setAvailability(null);
    skip().setUserMongo(null);
    skip().setOfferDuration(null);
  }
}
