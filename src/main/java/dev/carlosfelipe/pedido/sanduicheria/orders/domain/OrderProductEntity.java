package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

public class OrderProductEntity {
    private String name;
    
    private float price;

    private int quantity;
    
    public OrderProductEntity(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return price;
    }

    public float getFullPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
