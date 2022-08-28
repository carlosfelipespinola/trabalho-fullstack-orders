package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models.OrderDatabaseModel;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.IOrderRepository;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;

@Component
public class OrderRepositoryAdapter implements IOrderRepository {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity delete(OrderEntity order) {
        OrderDatabaseModel orderMapper = OrderDatabaseModel.fromOrderEntity(order);
        orderRepository.delete(orderMapper);
        return order;
    }

    @Override
    public OrderEntity find(String id) throws OrderNotFoundException {
        Optional<OrderDatabaseModel> result = orderRepository.findById(id);
        if(result.isEmpty()) {
            throw new OrderNotFoundException();
        }
        OrderDatabaseModel orderMapper = result.get();
        return orderMapper.toOrderEntity();
    }

    @Override
    public ArrayList<OrderEntity> findAll() {
        Iterable<OrderDatabaseModel> ordersMappers = orderRepository.findAll();
        ArrayList<OrderEntity> orders = new ArrayList<>();
        for (OrderDatabaseModel orderMapper : ordersMappers) {
            orders.add(orderMapper.toOrderEntity());
        }
        return orders;
    }

    @Override
    public ArrayList<OrderEntity> findAllOf(String user) {
        return new ArrayList<>();
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        return null;
    }
    
}
