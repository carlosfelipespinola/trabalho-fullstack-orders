package dev.carlosfelipe.pedido.sanduicheria.orders.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.IOrderRepository;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.IPayment;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderUseCases;

@Service
public class OrdersService extends OrderUseCases {

    public OrdersService(
        @Autowired IOrderRepository orderRepository,
        @Autowired IPayment payment
    ) {
        super(orderRepository, payment);
        //TODO Auto-generated constructor stub
    }
    
}
