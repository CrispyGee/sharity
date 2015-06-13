package de.hfu.SharityOnline.elastic;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;

import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.setup.Repository;

public class ElasticSearchMongoGrabber {

  private static final Repository<OfferMongo> repository = new Repository<OfferMongo>();

  public static List<OfferMongo> getOffers(SearchResponse response) {
    List<OfferMongo> offersMongo = new ArrayList<OfferMongo>();
    SearchHit[] results = response.getHits().getHits();
    for (SearchHit hit : results) {
      offersMongo.add(repository.loadById(OfferMongo.class, hit.getId()));
    }
    return offersMongo;
  }

}
