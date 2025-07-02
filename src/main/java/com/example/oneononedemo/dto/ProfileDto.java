package com.example.oneononedemo.dto;

import com.example.oneononedemo.entity.User;
import java.sql.Timestamp;

public class ProfileDto {

  private Long id;
  private String phoneNumber;
  private String address;
  private User user;
  private Timestamp created;
  private Timestamp updated;

  public ProfileDto() {
  }

  public ProfileDto(Long id, String phoneNumber, String address, User user,
      Timestamp created, Timestamp updated) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.user = user;
    this.created = created;
    this.updated = updated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }

  public Timestamp getUpdated() {
    return updated;
  }

  public void setUpdated(Timestamp updated) {
    this.updated = updated;
  }
}
