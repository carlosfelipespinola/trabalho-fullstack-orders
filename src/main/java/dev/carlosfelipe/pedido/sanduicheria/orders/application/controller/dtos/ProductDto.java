package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;

public class ProductDto {
    public String name;
    public float unitPrice;
    public float fullPrice;
    public int quantity;    

    public ProductDto(String name, float unitPrice, float fullPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.fullPrice = fullPrice;
        this.quantity = quantity;
    }

    static ProductDto fromOrderProductEntity(OrderProductEntity product) {
        return new ProductDto(
            product.getName(),
            product.getUnitPrice(),
            product.getFullPrice(),
            product.getQuantity()
        );
    }

    OrderProductEntity tOrderProductEntity() {
        return new OrderProductEntity(name, unitPrice, quantity);
    }
}
