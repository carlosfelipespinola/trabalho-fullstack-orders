package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories;

import org.springframework.stereotype.Repository;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.IPayment;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.PaymentCreditCard;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.PaymentException;

@Repository
public class PaymentRepositoryAdapter implements IPayment {

    @Override
    public String charge(PaymentCreditCard creditCard) throws PaymentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refound(String paymentId) throws PaymentException {
        // TODO Auto-generated method stub
        
    }
    
}
