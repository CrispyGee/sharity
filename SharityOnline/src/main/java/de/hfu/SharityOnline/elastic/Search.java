package de.hfu.SharityOnline.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;

public class Search {
  
  
  private Client client;
  private Node node;
  
  public Search(){
    node = nodeBuilder().node();
    client = node.client();
  }

  public SearchResponse searchTest(String suchterm) {
    SearchResponse response = client.prepareSearch("users", "offers")
        .setTypes("user", "offer")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        .setQuery(buildOutterBoolQuery(Arrays.asList(buildInnerSearchQuery(suchterm))))
        .setFrom(0).setSize(60).setExplain(true)
        .execute()
        .actionGet();
    SearchHit[] results = response.getHits().getHits();
    System.out.println("Current results: " + results.length);
    for (SearchHit hit : results) {
      System.out.println("------------------------------");
      Map<String, Object> result = hit.getSource();
      System.out.println(result);
    }
    node.close();
    return response;
  }
  
  
  
  public BoolQueryBuilder buildOutterBoolQuery(List<BoolQueryBuilder> innerBoolQueries){
    BoolQueryBuilder outterBoolQuery = QueryBuilders.boolQuery();
    for (BoolQueryBuilder innerBoolQuery : innerBoolQueries) {
      outterBoolQuery.should(innerBoolQuery);
    }
    return outterBoolQuery;
  }
  
  public BoolQueryBuilder buildInnerSearchQuery(String suchterm){
    BoolQueryBuilder qb = QueryBuilders.boolQuery();
//    qb.should(QueryBuilders.matchQuery("_all", suchterm));
    qb.should(QueryBuilders.fuzzyQuery("_all", suchterm));
//    qb.should(QueryBuilders.prefixQuery("_all", suchterm));
    qb.should(QueryBuilders.matchPhrasePrefixQuery("_all", suchterm));
    return qb;
  }
  
}
