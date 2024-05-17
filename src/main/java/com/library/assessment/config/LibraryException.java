package com.library.assessment.config;

public class LibraryException extends RuntimeException {

  private final int httpCode;
  private final String message;

  public LibraryException(int value, String message) {
    this.httpCode = value;
    this.message = message;
  }

  public int getHttpCode() {
    return httpCode;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
