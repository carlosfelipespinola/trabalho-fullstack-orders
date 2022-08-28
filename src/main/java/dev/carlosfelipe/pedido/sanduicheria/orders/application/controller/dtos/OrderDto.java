package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import java.util.ArrayList;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

public class OrderDto {
    private String id;
    private String usuario;
    private String status;
    private float price;
    private ArrayList<ProductDto> products;

    public OrderDto() {}

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDto> products) {
        this.products = products;
    }

    
}
