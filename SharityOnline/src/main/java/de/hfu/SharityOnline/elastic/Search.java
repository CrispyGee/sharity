package de.hfu.SharityOnline.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;

import de.hfu.SharityOnline.entities.Offer;

public class Search {

  private Client client;
  private Node node;

  public Search() {
    node = nodeBuilder().node();
    client = node.client();
  }

  public List<Offer> searchWithFilter(FilterBuilder filter, String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm)).setPostFilter(filter).setFrom(0).setSize(20)
        .setExplain(false).execute().actionGet();
    printResult(suchterm, response);
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  public List<Offer> searchAllActive(String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm)).setPostFilter(buildActiveOnlyFilter()).setFrom(0)
        .setSize(20).setExplain(false).execute().actionGet();
    printResult(suchterm, response);
    return ElasticSearchMongoGrabber.getOffers(response);
  }
  
  public List<Offer> searchAll(String suchterm) {
    SearchResponse response = client.prepareSearch("offers").setTypes("offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(buildMatchFuzzyQuery(suchterm)).setFrom(0)
        .setSize(20).setExplain(false).execute().actionGet();
    printResult(suchterm, response);
    return ElasticSearchMongoGrabber.getOffers(response);
  }

  private FilterBuilder buildActiveOnlyFilter() {
    FilterBuilder filter = FilterBuilders.termFilter("active", true);
    return filter;
  }

  private void printResult(String suchterm, SearchResponse response) {
    SearchHit[] results = response.getHits().getHits();
    System.out.println("SearchTerm: " + suchterm + "  Current results: " + results.length);
    for (SearchHit hit : results) {
      System.out.println("------------------------------");
      Map<String, Object> result = hit.getSource();
      System.out.println(result);
    }
  }

//  private List<BoolQueryBuilder> splitSearchTermIntoQueries(String searchterm) {
//    List<BoolQueryBuilder> innerQueryList = new ArrayList<BoolQueryBuilder>();
//    if (searchterm.contains(" ")) {
//      String[] searchterms = searchterm.split(" ");
//      for (String currentSearchterm : searchterms) {
//        innerQueryList.add(buildInnerSearchQuery(currentSearchterm));
//      }
//    }
//    return innerQueryList;
//  }
//
//  public BoolQueryBuilder buildOutterBoolQuery(List<BoolQueryBuilder> innerBoolQueries) {
//    BoolQueryBuilder outterBoolQuery = QueryBuilders.boolQuery();
//    for (BoolQueryBuilder innerBoolQuery : innerBoolQueries) {
//      outterBoolQuery.must(innerBoolQuery);
//    }
//    return outterBoolQuery;
//  }

  public BoolQueryBuilder buildMatchFuzzyQuery(String suchterm) {
    BoolQueryBuilder qb = QueryBuilders.boolQuery();
    qb.should(QueryBuilders.matchQuery("_all", suchterm));
    qb.should(QueryBuilders.fuzzyQuery("_all", suchterm));
    return qb;
  }

  public void close() {
    node.close();
  }

}
