package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

import java.util.ArrayList;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;

public interface IOrderRepository {
    OrderEntity find(String id) throws OrderNotFoundException;
    ArrayList<OrderEntity> findAll();
    ArrayList<OrderEntity> findAllOf(String user);
    OrderEntity save(OrderEntity order);
    OrderEntity delete(OrderEntity order);
}
