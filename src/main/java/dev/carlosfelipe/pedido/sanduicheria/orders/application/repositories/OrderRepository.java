package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.IOrderRepository;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;

@Repository
public class OrderRepository implements IOrderRepository {

    @Override
    public OrderEntity delete(OrderEntity order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderEntity find(String id) throws OrderNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<OrderEntity> findAll() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public ArrayList<OrderEntity> findAllOf(String user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
