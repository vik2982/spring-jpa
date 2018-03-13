package com.va.dal.model;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "addressId")
  private int id;

  private String postcode;
  
  public Address() { 
  }
  
  public Address (String postcode) {
	  this.postcode = postcode;
  }
  
  public int getId() {
      return id;
  }
  
  public void setId(int id) {
      this.id = id;
  }
  
  public String getPostcode() {
      return postcode;
  }

  public void setPostcode(String postcode) {
      this.postcode = postcode;
  }

}