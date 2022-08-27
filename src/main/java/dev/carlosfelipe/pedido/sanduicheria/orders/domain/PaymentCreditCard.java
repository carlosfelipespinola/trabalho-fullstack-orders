package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

import java.time.OffsetDateTime;

public class PaymentCreditCard {
    final String cvv;
    final OffsetDateTime expirationDate;
    final String number;
    final String owner;
    
    public PaymentCreditCard(String cvv, OffsetDateTime expirationDate, String number, String owner) {
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.number = number;
        this.owner = owner;
    }
}
