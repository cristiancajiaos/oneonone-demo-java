package com.example.oneononedemo.exception;

public class ProfileNotFoundException extends Exception {

  public static final Long serialVersionUID = 1L;

  public ProfileNotFoundException() {
  }

  public ProfileNotFoundException(String message) {
    super(message);
  }
}
