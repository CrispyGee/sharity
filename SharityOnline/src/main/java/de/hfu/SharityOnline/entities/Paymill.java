package de.hfu.SharityOnline.entities;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("paymilltransactions")
public class Paymill implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  private String trans_id;
  private String pay_id;
  private String offer_id;
  private String user_id;

  public String getOffer_id() {
    return offer_id;
  }

  public void setOffer_id(String offer_id) {
    this.offer_id = offer_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getPay_id() {
    return pay_id;
  }

  public void setPay_id(String pay_id) {
    this.pay_id = pay_id;
  }

  public String getTrans_id() {
    return trans_id;
  }

  public void setTrans_id(String trans_id) {
    this.trans_id = trans_id;
  }

}
