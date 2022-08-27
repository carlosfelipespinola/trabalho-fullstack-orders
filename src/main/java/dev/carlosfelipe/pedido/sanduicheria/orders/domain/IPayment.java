package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.PaymentException;

public interface IPayment {
    String charge(PaymentCreditCard creditCard) throws PaymentException;
    void refound(String paymentId) throws PaymentException;
}
