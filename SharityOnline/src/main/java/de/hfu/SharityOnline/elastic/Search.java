package de.hfu.SharityOnline.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

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

public class Search {

  private Client client;
  private Node node;

  public Search() {
    node = nodeBuilder().node();
    client = node.client();
  }

  public List<OfferMongo> searchActiveWithFilter(FilterBuilder filter, String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm))
        .setPostFilter(addActiveOnlyFilter(filter)).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<OfferMongo> searchAllActive(String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm))
        .setPostFilter(buildActiveOnlyFilter()).setFrom(0).setSize(20).setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<OfferMongo> searchAll(String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm)).setFrom(0).setSize(20)
        .setExplain(false).execute().actionGet();
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public BoolQueryBuilder buildMatchFuzzyQuery(String suchterm) {
    BoolQueryBuilder qb = QueryBuilders.boolQuery();
    qb.should(QueryBuilders.matchQuery("_all", suchterm));
    qb.should(QueryBuilders.fuzzyQuery("_all", suchterm));
    return qb;
  }

  public void close() {
    node.close();
  }

  private FilterBuilder addActiveOnlyFilter(FilterBuilder filter) {
    return FilterBuilders.andFilter(filter, buildActiveOnlyFilter());
  }

  private FilterBuilder buildActiveOnlyFilter() {
    FilterBuilder filter = FilterBuilders.termFilter("active", true);
    return filter;
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
