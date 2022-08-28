package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import java.util.ArrayList;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;

public class OrderListDto extends ArrayList<OrderDto> {
    private ArrayList<OrderDto> orders;

    public OrderListDto() {}

    public OrderListDto(ArrayList<OrderDto> orders) {
        this.orders = orders;
    }

    public static OrderListDto fromOrderEntity(ArrayList<OrderEntity> orders) {
        ArrayList<OrderDto> _orders = new ArrayList<>(orders.size());
        for (OrderEntity order : orders) {
            _orders.add(OrderDto.fromOrderEntity(order));
        }
        return new OrderListDto(_orders);
    }

    public ArrayList<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<OrderDto> orders) {
        this.orders = orders;
    }
}
