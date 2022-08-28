package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductModel {

  public String name;

  public float price;

  public int quantity;

  public OrderProductModel(String name, float price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}
