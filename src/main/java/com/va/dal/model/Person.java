package com.va.dal.model;

import javax.persistence.*;

@Entity
@Table(name="PERSON")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="personId")
  private int id;

  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name="addressId")
  private Address address;
  
  private String name;
  
  public Person() {
  }
  
  public Person (Address address,String name) {
      this.address = address;
      this.name = name;
  }

  public int getId() {
      return id;
  }
  
  public void setId(int id) {
      this.id = id;
  }
  
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public Address getAddress() {
      return address;
  }

  public void setAddress(Address address) {
      this.address = address;
  }

}
