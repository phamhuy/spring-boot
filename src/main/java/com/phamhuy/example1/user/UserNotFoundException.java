package com.phamhuy.example1.user;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String message) {
    super(message);
  }

}