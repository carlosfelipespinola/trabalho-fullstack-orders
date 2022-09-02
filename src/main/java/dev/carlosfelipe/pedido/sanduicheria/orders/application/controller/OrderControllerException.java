package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller;

import org.springframework.http.HttpStatus;

public class OrderControllerException {
  private String message;
  private String code;
  private HttpStatus status;

  public OrderControllerException(String message, String code, HttpStatus status) {
    this.message = message;
    this.code = code;
    this.status = status;
  }

  public String getCode() {
    return code;
  }
  
  public String getMessage() {
    return message;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
