package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

@Entity
@Table(name = "products")
public class OrderProductModel extends OrderProductEntity {

  public OrderProductModel(String name, float price, int quantity) {
    super(name, price, quantity);
  }

  @Id
  @Column
  private String id;
  
  @Override
  @Column(name = "name")
  public String getName() {
    return super.getName();
  }

  @Override
  @Column(name = "price")
  public float getUnitPrice() {
    return super.getUnitPrice();
  }

  @Override
  @Column(name = "quantity")
  public int getQuantity() {
    return super.getQuantity();
  }
}
