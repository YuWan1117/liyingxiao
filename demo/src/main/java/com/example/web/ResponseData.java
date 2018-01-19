package com.example.web;

import java.io.Serializable;

public class ResponseData implements Serializable {
  private int code;
  private String message;

  public ResponseData(int code) {
    this.setCode(code);
    this.setMessage("Failed.");
  }

  public ResponseData(String msg) {
    this.setCode(200);
    this.setMessage(msg);
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
