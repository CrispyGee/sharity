package de.hfu.SharityOnline;

import org.junit.Test;

import de.hfu.SharityOnline.backend.Search;

public class SearchTest {
  
  @Test
  public void testest(){
    System.out.println(Search.search("Max").getHits().getTotalHits());
  }

}
