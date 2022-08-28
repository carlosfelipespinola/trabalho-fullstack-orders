package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

@Entity
@Table(name="orders")
public class OrderDatabaseModel {

  @Column
  @Id
  public String id;

  @Column
  public String user;

  @Column
  public String paymentReceipt;

  @Enumerated(EnumType.ORDINAL)
  public OrderEntity.OrderStatus status;

  @ElementCollection
  public List<OrderProductModel> products;

  public OrderDatabaseModel(String id, String user, String paymentReceipt, OrderEntity.OrderStatus status, List<OrderProductModel> products) {
    this.id = id;
    this.user = user;
    this.paymentReceipt = paymentReceipt;
    this.products = products;
  }

  public static OrderDatabaseModel fromOrderEntity(OrderEntity order) {
    ArrayList<OrderProductModel> products = new ArrayList<>();
    for (OrderProductEntity product: order.getProducts()) {
      products.add(new OrderProductModel(
        product.getName(),
        product.getUnitPrice(),
        product.getQuantity())
      );
    }
    return new OrderDatabaseModel(
      order.getId(),
      order.getUsuario(),
      order.getPaymentReceiptId(),
      order.getStatus(),
      products
    );
  }

  public OrderEntity toOrderEntity() {
    ArrayList<OrderProductEntity> products = new ArrayList<>();
    for (OrderProductModel product: this.products) {
      products.add(new OrderProductEntity(
        product.name,
        product.price,
        product.quantity)
      );
    }
    return new OrderEntity(id, user, status, products, paymentReceipt);
  }

}
