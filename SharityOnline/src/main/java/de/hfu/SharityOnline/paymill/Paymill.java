package de.hfu.SharityOnline.paymill;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.paymill.context.PaymillContext;
import com.paymill.models.Client;
import com.paymill.models.Fee;
import com.paymill.models.Interval.Period;
import com.paymill.models.Offer;
import com.paymill.models.Payment;
import com.paymill.models.Transaction;
import com.paymill.services.ClientService;
import com.paymill.services.OfferService;
import com.paymill.services.PaymentService;
import com.paymill.services.TransactionService;

public class Paymill {
  PaymillContext paymillContext = new PaymillContext( "43359664a9f37c92a16737b711b0a26f" );
  

  
  /*
   *                   OFFER
   */
  public Offer createNewOffer(int amount, String currency, Period interval, String name) {
    OfferService offerService = paymillContext.getOfferService();
    return offerService.create(
        amount,
        currency, //"EUR"
        interval, //"1 WEEK"
        name,
        0
    );
  }
  
  public Offer getOfferDetailsById(String id) {
    OfferService offerService = paymillContext.getOfferService();
    return offerService.get(id); 
  }
  
  public void removeOfferbyId(String id) {
    OfferService offerService = paymillContext.getOfferService();
    boolean removeWithSubscriptions = true;
    offerService.delete( id, removeWithSubscriptions );
  }
  
  public Offer updateOffer(String id, int amount, String currency, Period interval, String name, int periodDays) {
    OfferService offerService = paymillContext.getOfferService();
    Offer offer = offerService.get( id );

    offer.setName(name);
    offer.setInterval(interval);
    offer.setAmount(amount);
    offer.setCurrency(currency);
    offer.setTrialPeriodDays(periodDays);

    boolean updateSubscriptions=true;
    offerService.update( offer,updateSubscriptions );
    return offer;
  }
  
  /*
   *                  Payments
   */
  public Payment createCreditcartpaymentWithToken(String token) {
    PaymentService paymentService = paymillContext.getPaymentService();
    return paymentService.createWithToken(token);
  }
  
  public Payment createCreditcartpaymentWithTokenAndClient(String token, Client client) {
    PaymentService paymentService = paymillContext.getPaymentService();
    return paymentService.createWithTokenAndClient(token, client);
  }
  
  public Payment createDebitPaymentWithToken(String token) {
    PaymentService paymentService = paymillContext.getPaymentService();
    return paymentService.createWithToken(token);
  }
  
  public Payment createDebitPaymentWithTokenAndClient(String token, Client client) {
    PaymentService paymentService = paymillContext.getPaymentService();
    return paymentService.createWithTokenAndClient(token,client);
  }
  /*
   *                  TRANSACTIONS
   */
  public Transaction createTransactionWithAppFee(int feeAmount, String payment, int transAmount, String currency, String token) {
    Fee fee = new Fee();
    fee.setAmount( feeAmount );
    fee.setPayment( payment ); //"pay_3af44644dd6d25c820a8"
    TransactionService transactionService = paymillContext.getTransactionService();
    return transactionService.createWithTokenAndFee(
        token,
        transAmount,
        currency,
        fee
    );
  }

  
  public Transaction createTransactionWithClientAndPayment(Payment payment, Client client, int amount, String currency, String description) {
    TransactionService transactionService = paymillContext.getTransactionService();
    return transactionService.createWithPaymentAndClient(payment, client, amount, currency, description);
  }
  
  public Transaction createTranscationWithPayment(String token, int amount, String currency, String description)  {
    PaymentService paymentService = paymillContext.getPaymentService();
    Payment payment = paymentService.createWithToken(token);
    TransactionService transactionService = paymillContext.getTransactionService();
    return transactionService.createWithPayment(payment, amount, currency, description);
  }
  
  
//  @Produces(MediaType.APPLICATION_JSON)
//  public void createNewOffer() {
//     try {
//       Unirest.post("https://paymill.p.mashape.com/offers")
//          .header("Authorization", "<required>")
//          .header("X-Mashape-Key", "<required>")
//          .header("Content-Type", "application/x-www-form-urlencoded")
//          .header("Accept", "text/plain")
//          .asString();
//    } catch (UnirestException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//  }
//  public void createOffer(int amount, String currency, String interval, String name) throws UnirestException {
//    com.mashape.unirest.http.HttpResponse<String> kek = Unirest.post("https://paymill.p.mashape.com/offers")
//        .header("Authorization", "Basic NDMzNTk2NjRhOWYzN2M5MmExNjczN2I3MTFiMGEyNmY6")
//        .header("X-Mashape-Key", "R6awQAYQ05mshnwVkA63cfmXwajIp1Z26wGjsnO0inQoz0FHR0")
//        .header("Content-Type", "application/x-www-form-urlencoded")
//        .header("Accept", "text/plain")
//        .field("amount", amount) // "200" (in cent)
//        .field("currency", currency) //"USD"
//        .field("interval", interval) //"2 DAY"
//        .field("name", name) //"Sophie"
//        .asString();
//    System.out.println(kek);
//    System.out.println(kek.getBody());
//    System.out.println(kek.getStatusText());
//    System.out.println(kek.getStatus());
//  }
//  
//  public String createTransaction(int amount, String currency, String description, String token) throws UnirestException {
//    return Unirest.post("https://paymill.p.mashape.com/transactions")
//        .header("Authorization", "Basic NDMzNTk2NjRhOWYzN2M5MmExNjczN2I3MTFiMGEyNmY6")
//        .header("X-Mashape-Key", "Pgb2SfxgDlmshHD9X7MB4VYIQYgOp1UI5VZjsnjJKKPXbnxvcT")
//        .header("Content-Type", "application/x-www-form-urlencoded")
//        .header("Accept", "text/plain")
//        .field("amount", amount)
//        .field("currency", currency)
//        .field("description", description)
//        .field("token", token) //client_88a388d9dd48f86c3136
//        .asString().getBody();
//  }
//  
//  public String removePayment() throws UnirestException {
//  return (Unirest.delete("https://paymill.p.mashape.com/payments/{id}")
//      .header("Authorization", "Basic NDMzNTk2NjRhOWYzN2M5MmExNjczN2I3MTFiMGEyNmY6")
//      .header("X-Mashape-Key", "Pgb2SfxgDlmshHD9X7MB4VYIQYgOp1UI5VZjsnjJKKPXbnxvcT")
//      .header("Accept", "text/plain")
//      .asString()).getBody();
//  }
//  
//  public String createPayment(String client) throws UnirestException {
//   return Unirest.post("https://paymill.p.mashape.com/payments")
//       .header("Authorization", "Basic NDMzNTk2NjRhOWYzN2M5MmExNjczN2I3MTFiMGEyNmY6")
//       .header("X-Mashape-Key", "Pgb2SfxgDlmshHD9X7MB4VYIQYgOp1UI5VZjsnjJKKPXbnxvcT")
//       .header("Content-Type", "application/x-www-form-urlencoded")
//       .header("Accept", "text/plain")
//       .field("client", client)// client_88a388d9dd48f86c3136
//       .asString().getBody(); 
//  }
    
}
