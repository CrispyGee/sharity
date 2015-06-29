package de.hfu.SharityOnline.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.entities.CategoryToken;
import de.hfu.SharityOnline.entities.Paymill;
import de.hfu.SharityOnline.entities.UserMongo;
import de.hfu.SharityOnline.innerObjects.OfferDuration;
import de.hfu.SharityOnline.setup.Repository;

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
public class PaymillRestSchnittstelle {
  private final String jsonErrorMsg = "{\"error\": \"x\"}";
  private static final Repository<UserMongo> USER_REPO = new Repository<UserMongo>();
  private static final Repository<Paymill> PAYMENT_REPO = new Repository<Paymill>();
  private static final Repository<Category> CATEGORY_REPO = new Repository<Category>();
  private static final String privateKey = "43359664a9f37c92a16737b711b0a26f";

  // private static final String publicKey = "71850066712bad20cdf3f646c5c74761";

  @PermitAll
  @GET
  @Path("/{userId}/{token}")
  public Response transferPayment(@PathParam("userId") String userId, @PathParam("token") String token)
      throws Exception {
    UserMongo userMongo = USER_REPO.loadById(UserMongo.class, userId);
    if (userMongo != null) {
      try {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse paymentResponse = callPaymentRest(token, httpClient);
        String pay_id = getIdFromResponse(paymentResponse);
        CloseableHttpResponse transactionResponse = callTransactionRest(pay_id, httpClient, userMongo.getUsername(),
            "1000");
        String trans_id = getIdFromResponse(transactionResponse);
        paymentResponse.close();
        transactionResponse.close();
        updatePaymillLog(userId, pay_id, trans_id);
        return Response.status(Status.ACCEPTED).build();
      } catch (Exception e) {
        return Response.status(Status.BAD_REQUEST)
            .entity(jsonErrorMsg.replace("x", "There was an error during the payment process, possibly a fraud"))
            .build();
      }
    } else {
      return Response.status(Status.PRECONDITION_FAILED)
          .entity(jsonErrorMsg.replace("x", "User not logged in or not found")).build();
    }
  }

  @PermitAll
  @GET
  @Path("/{userId}/{token}/{category_id}/{supply_demand}/{offer_duration}")
  public Response transferPaymentWithCategory(@PathParam("userId") String userId, @PathParam("token") String token,
      @PathParam("category_id") String category_id, @PathParam("supply_demand") String supply_demand,
      @PathParam("offer_duration") OfferDuration offer_duration) throws Exception {
    try {
      System.out.println(userId);
      System.out.println(token);
      System.out.println(category_id);
      System.out.println(supply_demand);
      System.out.println(offer_duration);
      UserMongo userMongo = USER_REPO.loadById(UserMongo.class, userId);
      if (userMongo != null) {
        Category category = CATEGORY_REPO.loadById(Category.class, category_id);
        if (category != null) {
          try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse paymentResponse = callPaymentRest(token, httpClient);
            String pay_id = getIdFromResponse(paymentResponse);
            CloseableHttpResponse transactionResponse = callTransactionRest(pay_id, httpClient,
                userMongo.getUsername(), Integer.toString(category.getPrice(supply_demand, offer_duration)));
            String trans_id = getIdFromResponse(transactionResponse);
            paymentResponse.close();
            transactionResponse.close();
            updatePaymillLog(userId, pay_id, trans_id);
            updateUserTokens(userMongo, category_id, offer_duration, supply_demand);
            return Response.status(Status.ACCEPTED).build();
          } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST)
                .entity(jsonErrorMsg.replace("x", "There was an error during the payment process, possibly a fraud"))
                .build();
          }
        } else {
          return Response.status(Status.PRECONDITION_FAILED).entity(jsonErrorMsg.replace("x", "Category not found"))
              .build();
        }
      } else {
        return Response.status(Status.PRECONDITION_FAILED)
            .entity(jsonErrorMsg.replace("x", "User not logged in or not found")).build();
      }
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

  private void updatePaymillLog(String userId, String pay_id, String trans_id) {
    Paymill paymill = new Paymill();
    paymill.setPay_id(pay_id);
    paymill.setTrans_id(trans_id);
    paymill.setUser_id(userId);
    PAYMENT_REPO.save(paymill);
  }

  @SuppressWarnings("deprecation")
  private CloseableHttpResponse callPaymentRest(String token, CloseableHttpClient httpClient) throws IOException,
      ClientProtocolException {
    HttpPost httpPost = new HttpPost("https://api.paymill.com/v2.1/payments");
    httpPost.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials(privateKey, ""), "UTF-8", false));
    List<NameValuePair> formData = new ArrayList<NameValuePair>();
    formData.add(new BasicNameValuePair("token", token));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formData, Consts.UTF_8);
    httpPost.setEntity(entity);
    CloseableHttpResponse response2 = httpClient.execute(httpPost);
    return response2;
  }

  @SuppressWarnings("deprecation")
  private CloseableHttpResponse callTransactionRest(String pay_id, CloseableHttpClient httpClient, String description,
      String price) throws IOException, ClientProtocolException {
    HttpPost httpPost = new HttpPost("https://api.paymill.com/v2.1/transactions");
    httpPost.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials(privateKey, ""), "UTF-8", false));
    List<NameValuePair> formData = new ArrayList<NameValuePair>();
    formData.add(new BasicNameValuePair("amount", price));
    formData.add(new BasicNameValuePair("currency", "EUR"));
    formData.add(new BasicNameValuePair("payment", pay_id));
    formData.add(new BasicNameValuePair("description", description));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formData, Consts.UTF_8);
    httpPost.setEntity(entity);
    CloseableHttpResponse response2 = httpClient.execute(httpPost);
    return response2;
  }

  private String getIdFromResponse(CloseableHttpResponse response2) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(10000);
    // response2.getEntity().writeTo(System.out);
    response2.getEntity().writeTo(baos);
    String responseJson = new String(baos.toByteArray());
    String[] splitJson = responseJson.split("\"id\":\"");
    String result = splitJson[1].split("\"")[0];
    return result;
  }

  private void updateUserTokens(UserMongo userMongo, String category_id, OfferDuration offer_duration,
      String supply_demand) {
    Category category = CATEGORY_REPO.loadById(Category.class, category_id);
    userMongo.increaseOfferCategoryTokens(new CategoryToken(offer_duration, category, supply_demand));
    USER_REPO.save(userMongo);
  }

}
