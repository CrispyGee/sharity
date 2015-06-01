package de.hfu.SharityOnline.backend;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;

public class Search {

  public static SearchResponse search(String suchterm) {
    // on startup
    Node node = nodeBuilder().node();
    Client client = node.client();
    BoolQueryBuilder qb = QueryBuilders.boolQuery();
    qb.should(QueryBuilders.prefixQuery("vorname", suchterm));
    qb.should(QueryBuilders.prefixQuery("nachname", suchterm));
    SearchResponse response = client.prepareSearch("angebote", "mongoindex").setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(qb) // Query
        .setFrom(0).setSize(60).setExplain(true).execute().actionGet();
    node.close();
    return response;
  }

}
