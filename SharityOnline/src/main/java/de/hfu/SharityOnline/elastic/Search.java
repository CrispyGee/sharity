package de.hfu.SharityOnline.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;

import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.innerObjects.Availability;
import de.hfu.SharityOnline.innerObjects.Salutation;

public class Search {
  
//  private static final Logger LOGGER = LogManager.getLogger(Search.class);


  private Client client;
  private Node node;

  public Search() {
    node = nodeBuilder().data(false).client(true).node();
    client = node.client();
  }

  public String splitSearchTerm(String searchterm) {
    if (searchterm.contains("_")) {
      String[] splitterm = searchterm.split("_");
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < splitterm.length; i++) {
        result.append(splitterm[i]);
        if (i < splitterm.length - 1) {
          result.append(" ");
        }
      }
      return result.toString();
    } else {
      return searchterm;
    }
  }

  public List<OfferMongo> searchActiveWithFilter(FilterBuilder filter, String searchterm) {
    String cleanSearchTerm = splitSearchTerm(searchterm);
    SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(client);
    searchRequestBuilder.setIndices("offers").setTypes("offer").setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        .setQuery(buildMatchFuzzyQuery(cleanSearchTerm)).setPostFilter(filter).setFrom(0).setSize(20).setExplain(false);
//    LOGGER.info(searchRequestBuilder.internalBuilder());
    SearchResponse response = searchRequestBuilder.execute().actionGet();
    // client.prepareSearch("offers").setTypes("offer")
    // .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(cleanSearchTerm))
    // .setPostFilter(filter).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<OfferMongo> searchAllActive(String searchterm) {
    String cleanSearchTerm = splitSearchTerm(searchterm);
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(cleanSearchTerm))
        .setPostFilter(SharityFilterBuilder.buildActiveOnlyFilter()).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<OfferMongo> searchAll(String searchterm) {
    String cleanSearchTerm = splitSearchTerm(searchterm);
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(cleanSearchTerm)).setFrom(0)
        .setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public BoolQueryBuilder buildMatchFuzzyQuery(String suchterm) {
    BoolQueryBuilder qb = QueryBuilders.boolQuery();
    // qb.should(QueryBuilders.matchQuery("_all", suchterm));
    qb.should(QueryBuilders.fuzzyQuery("_all", suchterm));
    qb.should(QueryBuilders.matchPhrasePrefixQuery("_all", suchterm));
    return qb;
  }

  public void close() {
    node.close();
  }

  public FilterBuilder mapFilterCriteria(String login_state, Integer salutation, String hometown, Double within,
      Integer age, Double price, Integer availability, String category_id, Long creation_date) {
    List<FilterBuilder> filters = new ArrayList<FilterBuilder>();
    filters.add(SharityFilterBuilder.buildActiveOnlyFilter());
    // TODO login_state, within
    if (salutation != null) {
      filters.add(SharityFilterBuilder.buildSalutationFilter(Salutation.fromNumber(salutation)));
    }
    if (StringUtils.isNotBlank(hometown)) {
      filters.add(SharityFilterBuilder.buildHometownFilter(hometown));
    }
    if (age != null) {
      filters.add(SharityFilterBuilder.buildAgeFilter(age));
    }
    if (price != null) {
      filters.add(SharityFilterBuilder.buildPriceFilter(price));
    }
    if (availability != null) {
      filters.add(SharityFilterBuilder.buildAvailabilityFilter(Availability.fromNumber(availability)));
    }
    if (StringUtils.isNotBlank(category_id)) {
      filters.add(SharityFilterBuilder.buildCategoryFilter(category_id));
    }
    if (creation_date != null) {
      filters.add(SharityFilterBuilder.buildCreationdateFilter(creation_date));
    }
    return SharityFilterBuilder.combineAllFilters(filters);
  }

  // private static void printResult(SearchResponse response) {
  // SearchHit[] results = response.getHits().getHits();
  // System.out.println("------------------------------");
  // System.out.println("------------------------------");
  // System.out.println("Current results: " + results.length);
  // for (SearchHit hit : results) {
  // System.out.println("------------------------------");
  // Map<String, Object> result = hit.getSource();
  // System.out.println(result);
  // }
  // }

}
