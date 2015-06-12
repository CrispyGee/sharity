package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.elastic.Search;

public class SearchTest {
  
  @Test
  public void testest(){
    Search search = new Search();
//    search.searchTest("Muster");
    search.searchTest("Student");
    search.searchTest("student");
    search.searchTest("77955");
    search.searchTest("7795");
    search.close();
  }

}
