package de.hfu.SharityOnline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Ignore;
import org.junit.Test;

import de.hfu.SharityOnline.entities.User;

@Ignore
public class RestTest {
  public User createUserWithArguments(String id, String username, String firstname, String lastname, String zip, String phone, String email, String hometown) {
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    user.setFirstname(firstname);
    user.setLastname(lastname);
    user.setZip(zip);
    user.setPhone(phone);
    user.setEmail(email);
    user.setHometown(hometown);
    return user;
  }
  
  @Test 
  public void httpPost() throws Exception { 
    String line;
    StringBuffer jsonString = new StringBuffer();
    User usr = createUserWithArguments("user_id1", "username", "Sophie", "Dietrich", "70178", "01782839021", "ann-sophie.dietrich@hs-furtwangen.de", "Furtwangen");
    usr.setPassword("123");
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(usr);
    try {
        URL url = new URL("http://localhost:8080/SharityOnline/user/new");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(json.toString());
        writer.flush();
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = br.readLine()) != null) {
                jsonString.append(line);
        }
        br.close();
        connection.disconnect();
    } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
    }
  }
  
  @Test
  public void httpPut() throws JsonGenerationException, JsonMappingException, IOException{
    String line;
    StringBuffer jsonString = new StringBuffer();
    User usr = createUserWithArguments("47a57f2a-4585-4f75-a0e1-b87dd6184d3a", "username", "SophSoph", "Dietrich", "70178", "01782839021", "ann-sophie.dietrich@hs-furtwangen.de", "Furtwangen");
    usr.setPassword("123");
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(usr);
    try {
      URL url = new URL("http://localhost:8080/SharityOnline/user/update");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput(true);
      connection.setDoOutput(true);
      connection.setRequestMethod("PUT");
      connection.setRequestProperty("Accept", "application/json");
      connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
      writer.write(json.toString());
      writer.flush();
      writer.close();
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((line = br.readLine()) != null) {
              jsonString.append(line);
      }
      br.close();
      connection.disconnect();
    } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
    }
    
  }
}

