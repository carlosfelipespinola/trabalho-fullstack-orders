package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

import java.util.ArrayList;

public class OrderEntity {

    public enum OrderStatus { pending, canceled, accepted }

    private String id;

    private String usuario;

    private OrderStatus status;

    private String paymentReceiptId;

    private ArrayList<OrderProductEntity> products;

    public OrderEntity(String id, String usuario, OrderStatus status, ArrayList<OrderProductEntity> products, String paymentReceiptId) {
        this.id = id;
        this.usuario = usuario;
        this.status = status;
        this.products = products;
        this.paymentReceiptId = paymentReceiptId;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPaymentReceiptId() {
        return paymentReceiptId;
    }

    public boolean isOwnedByUser(String user) {
        return usuario.equals(user);
    };

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ArrayList<OrderProductEntity> getProducts() {
        return products;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getPrice() {
        float price = 0;
        for (OrderProductEntity product: products) {
            price += product.getFullPrice();
        }
        return price;
    }
}


