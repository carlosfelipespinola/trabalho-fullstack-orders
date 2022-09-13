package dev.carlosfelipe.pedido.sanduicheria.orders.domain;


public class PaymentCreditCard {
    final String cvv;
    final String expirationDate;
    final String number;
    final String owner;
    
    public PaymentCreditCard(String cvv, String expirationDate, String number, String owner) {
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.number = number;
        this.owner = owner;
    }
}
