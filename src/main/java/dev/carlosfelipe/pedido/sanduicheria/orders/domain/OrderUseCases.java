package dev.carlosfelipe.pedido.sanduicheria.orders.domain;

import java.util.ArrayList;
import java.util.UUID;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity.OrderStatus;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.*;

public class OrderUseCases {
    IOrderRepository orderRepository;
    IPayment payment;


    public OrderUseCases(IOrderRepository orderRepository, IPayment payment) {
        this.orderRepository = orderRepository;
        this.payment = payment;
    }


    public OrderEntity create(String user, ArrayList<OrderProductEntity> products, PaymentCreditCard creditCard) throws PaymentException, OrderInvalidException {
        String id = UUID.randomUUID().toString();
        OrderStatus status = OrderStatus.pending;
        final OrderEntity order = new OrderEntity(id, user, status, products, null);
        if (!order.isValid()) {
            throw new OrderInvalidException();
        }
        String receipt = payment.charge(creditCard);
        order.setPaymentReceiptId(receipt);
        return orderRepository.save(order);
    }

    public OrderEntity accept(String orderId) throws OrderNotFoundException {
        final OrderEntity order = orderRepository.find(orderId);
        order.setStatus(OrderStatus.accepted);
        return orderRepository.save(order);
    }

    public OrderEntity cancel(String user, String orderId)
        throws OrderNotFoundException,
        OrderMutationForbiddenException,
        PaymentException
    {
        final OrderEntity order = orderRepository.find(orderId);
        if (!order.isOwnedByUser(user)) {
            throw new OrderMutationForbiddenException();
        }
        payment.refound(order.getPaymentReceiptId());
        order.setStatus(OrderStatus.canceled);
        return orderRepository.save(order);
    }

    public OrderEntity cancel(String orderId) throws OrderNotFoundException, PaymentException
    {
        final OrderEntity order = orderRepository.find(orderId);
        payment.refound(order.getPaymentReceiptId());
        order.setStatus(OrderStatus.canceled);
        return orderRepository.save(order);
    }

    public ArrayList<OrderEntity> findAll() { return orderRepository.findAll(); }

    public ArrayList<OrderEntity> findAllOf(String user) { return orderRepository.findAllOf(user); }
}
