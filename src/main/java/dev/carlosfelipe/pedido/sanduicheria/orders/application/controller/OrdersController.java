package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos.OrderCreationDto;
import dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos.OrderDto;
import dev.carlosfelipe.pedido.sanduicheria.orders.application.services.OrdersService;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderMutationForbiddenException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.PaymentException;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    
    @PostMapping("/orders")
    OrderDto create(@RequestBody OrderCreationDto dto) throws PaymentException {
        final OrderEntity createdOrder = ordersService.create(
            dto.getUser(),
            dto.getProductEntities(),
            dto.getPaymentMethod()
        );
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @PatchMapping("/orders/{id}/cancel")
    OrderDto cancel(@PathVariable String id) throws OrderNotFoundException, PaymentException {
        final OrderEntity createdOrder = ordersService.cancel(id);
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @PatchMapping("/orders/user/{user}/{order}/cancel")
    OrderDto cancel(@PathVariable String user, @PathVariable String order)
    throws OrderNotFoundException, OrderMutationForbiddenException, PaymentException {
        final OrderEntity createdOrder = ordersService.cancel(user, order);
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @GetMapping("/orders")
    ArrayList<OrderDto> findAll() {
        final ArrayList<OrderEntity> orders = ordersService.findAll();
        System.out.println(orders.toString());
        ArrayList<OrderDto> dtos = new ArrayList<>();
        for (OrderEntity orderEntity : orders) {
            dtos.add(OrderDto.fromOrderEntity(orderEntity));
        }
        return new ArrayList<>();
    }

    @GetMapping("/orders/user/{userid}")
    ArrayList<OrderDto> findAllOfUser(@PathVariable String userid) {
        final ArrayList<OrderEntity> orders = ordersService.findAllOf(userid);
        ArrayList<OrderDto> dtos = new ArrayList<>();
        for (OrderEntity orderEntity : orders) {
            dtos.add(OrderDto.fromOrderEntity(orderEntity));
        }
        return dtos;
    }

}
