package com.sci.feb22.exceptions;

public class CustomException extends Exception {

  private static final long serialVersionUID = 3110482185260436146L;

  public CustomException(String message) {
    super(message);
  }
}
