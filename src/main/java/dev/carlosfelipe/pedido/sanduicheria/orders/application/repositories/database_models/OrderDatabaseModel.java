package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

@Entity
@Table(name="orders")
public class OrderDatabaseModel extends OrderEntity {
  public OrderDatabaseModel(String id, String usuario, OrderStatus status, ArrayList<OrderProductEntity> products, String paymentReceiptId) {
    super(id, usuario, status, products, paymentReceiptId);
  }

  @Override
  @Id
  @Column(name = "id")
  public String getId() { return super.getId(); }

  @Override
  @Column(name = "user")
  public String getUsuario() { return super.getUsuario(); }

  @Override
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "status")
  public OrderStatus getStatus() { return super.getStatus(); }

  @Override
  @Column(name = "payment_receipt")
  public String getPaymentReceiptId() { return super.getPaymentReceiptId(); }
}
