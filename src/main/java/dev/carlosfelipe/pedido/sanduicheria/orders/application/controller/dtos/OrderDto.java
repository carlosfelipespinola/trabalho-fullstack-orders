package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import java.util.ArrayList;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

public class OrderDto {
    public String id;
    public String usuario;
    public String status;
    public float price;
    public ArrayList<ProductDto> products;

    public OrderDto(String id, String usuario, String status, float price, ArrayList<ProductDto> products) {
        this.id = id;
        this.usuario = usuario;
        this.status = status;
        this.price = price;
        this.products = products;
    }

    public static OrderDto fromOrderEntity(OrderEntity order) {
        ArrayList<ProductDto> _products = new ArrayList<>(order.getProducts().size());
        for (OrderProductEntity productEntity : order.getProducts()) {
            _products.add(ProductDto.fromOrderProductEntity(productEntity));
        }
        return new OrderDto(
            order.getId(),
            order.getUsuario(),
            order.getStatus().toString(),
            order.getPrice(),
            _products
        );
    }
}
