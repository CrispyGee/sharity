package de.hfu.SharityOnline.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;

import de.hfu.SharityOnline.entities.OfferMongo;
import de.hfu.SharityOnline.innerObjects.Salutation;

public class Search {

  private Client client;
  private Node node;
  private static final long MILLS_IN_YEAR = 1000L * 60 * 60 * 24 * 365; // Returns 31536000000


  public Search() {
    node = nodeBuilder().node();
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

  public List<OfferMongo> searchActiveWithFilter(List<FilterBuilder> filterList, String searchterm) {
    String cleanSearchTerm = splitSearchTerm(searchterm);
    if(filterList == null){
      filterList = new ArrayList<FilterBuilder>();
    }
    filterList.add(buildActiveOnlyFilter());
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(cleanSearchTerm))
        .setPostFilter(combineAllFilters(filterList)).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<OfferMongo> searchAllActive(String searchterm) {
    String cleanSearchTerm = splitSearchTerm(searchterm);
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(cleanSearchTerm))
        .setPostFilter(buildActiveOnlyFilter()).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
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
//    qb.should(QueryBuilders.matchQuery("_all", suchterm));
    qb.should(QueryBuilders.fuzzyQuery("_all", suchterm));
    qb.should(QueryBuilders.matchPhrasePrefixQuery("_all", suchterm));
    return qb;
  }

  public void close() {
    node.close();
  }

  private FilterBuilder combineAllFilters(List<FilterBuilder> filters){
    return FilterBuilders.andFilter(filters.toArray(new FilterBuilder[filters.size()]));
  }

  private FilterBuilder buildActiveOnlyFilter() {
    return FilterBuilders.termFilter("active", true);
  }
  
  private FilterBuilder buildSalutationFilter(Salutation sal){
    return FilterBuilders.termFilter("salutation", sal.name());
  }
  
  private FilterBuilder buildHometownFilter(String hometown){
    return FilterBuilders.prefixFilter("userMongo.hometown", hometown);
  }
  
  private FilterBuilder buildAgeFilter(int age){
    long birthdayTimeInMillis = System.currentTimeMillis() - (MILLS_IN_YEAR * age);
    return FilterBuilders.rangeFilter("birthday").from(birthdayTimeInMillis-MILLS_IN_YEAR).to(birthdayTimeInMillis + MILLS_IN_YEAR);
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
