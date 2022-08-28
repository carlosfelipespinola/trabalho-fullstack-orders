package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductModel {

  private String name;

  private float price;

  private int quantity;

  public OrderProductModel() {}

  public OrderProductModel(String name, float price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  
}
