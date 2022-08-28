package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

public class ProductDto {
    private String name;
    private float price;
    private int quantity; 
    
    public ProductDto() {}

    public ProductDto(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    static ProductDto fromOrderProductEntity(OrderProductEntity product) {
        return new ProductDto(
            product.getName(),
            product.getUnitPrice(),
            product.getQuantity()
        );
    }

    OrderProductEntity tOrderProductEntity() {
        return new OrderProductEntity(name, price, quantity);
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
