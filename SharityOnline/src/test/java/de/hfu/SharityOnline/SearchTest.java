package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.elastic.Search;

public class SearchTest {
  
  @Test
  public void testest(){
    Search search = new Search();
//    search.searchTest("Muster");
    search.searchAllActive("Max Garten");
    search.searchAllActive("Mathe");
    search.searchAllActive("Gassi");
    search.searchAllActive("Babysitten");
    search.close();
  }

}
