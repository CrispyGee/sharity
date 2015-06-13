package de.hfu.SharityOnline;

import org.junit.Test;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.paymill.models.Payment;
import com.paymill.models.Transaction;

import de.hfu.SharityOnline.paymill.Paymill;


public class sharityTest {

  
  @Test
  public void testCreateTransaction() throws UnirestException {
    Paymill p = new Paymill();
   // System.out.println(p.createTransaction(200, "USD", "Kek", "client_88a388d9dd48f86c3136"));
    //p.createOffer(2000, "USD", "2 WEEK", "Soph");
  //  System.out.println(p.createPayment("client_88a388d9dd48f86c3136"));
   Transaction transi = p.createTranscationWithPayment("tok_5500000000000004", 1337, "EUR", "WAT");
   System.out.println(transi.getResponseCode());

    
  }
}
