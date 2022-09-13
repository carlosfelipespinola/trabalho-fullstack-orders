package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

@Entity
@Table(name="orders")
public class OrderDatabaseModel {

  @Column
  @Id
  private String id;

  @Column
  private String userId;

  @Column
  private String paymentReceipt;
  
  @Column
  @Enumerated(EnumType.STRING)
  private OrderEntity.OrderStatus status;

  @ElementCollection
  private List<OrderProductModel> products;

  @CreationTimestamp
  @Column(name = "created_at")
  private Instant createdAt;

  public OrderDatabaseModel() {}

  public OrderDatabaseModel(String id, String user, String paymentReceipt, OrderEntity.OrderStatus status, List<OrderProductModel> products) {
    this.id = id;
    this.userId = user;
    this.paymentReceipt = paymentReceipt;
    this.products = products;
    this.status = status;
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
        product.getName(),
        product.getPrice(),
        product.getQuantity())
      );
    }
    return new OrderEntity(id.toString(), userId, status, products, paymentReceipt);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPaymentReceipt() {
    return paymentReceipt;
  }

  public void setPaymentReceipt(String paymentReceipt) {
    this.paymentReceipt = paymentReceipt;
  }

  public OrderEntity.OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderEntity.OrderStatus status) {
    this.status = status;
  }

  public List<OrderProductModel> getProducts() {
    return products;
  }

  public void setProducts(List<OrderProductModel> products) {
    this.products = products;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
