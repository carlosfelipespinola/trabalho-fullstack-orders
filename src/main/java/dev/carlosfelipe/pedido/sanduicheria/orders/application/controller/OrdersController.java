package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos.OrderCreationDto;
import dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos.OrderDto;
import dev.carlosfelipe.pedido.sanduicheria.orders.application.services.OrdersService;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderInvalidException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderMutationForbiddenException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.PaymentException;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto create(@RequestBody OrderCreationDto dto) throws PaymentException, OrderInvalidException {
        final OrderEntity createdOrder = ordersService.create(
            dto.getUser(),
            dto.getProductEntities(),
            dto.getPaymentMethod()
        );
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @PatchMapping("/orders/{id}/cancel")
    @ResponseStatus(HttpStatus.OK)
    OrderDto cancel(@PathVariable String id) throws OrderNotFoundException, PaymentException {
        final OrderEntity createdOrder = ordersService.cancel(id);
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @PatchMapping("/orders/{id}/accept")
    @ResponseStatus(HttpStatus.OK)
    OrderDto accept(@PathVariable String id) throws OrderNotFoundException {
        final OrderEntity createdOrder = ordersService.accept(id);
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @PatchMapping("/orders/user/{user}/{order}/cancel")
    @ResponseStatus(HttpStatus.OK)
    OrderDto cancel(@PathVariable String user, @PathVariable String order)
    throws OrderNotFoundException, OrderMutationForbiddenException, PaymentException {
        final OrderEntity createdOrder = ordersService.cancel(user, order);
        return OrderDto.fromOrderEntity(createdOrder);
    }

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    ArrayList<OrderDto> findAll() {
        final ArrayList<OrderEntity> orders = ordersService.findAll();
        ArrayList<OrderDto> dtos = new ArrayList<>();
        for (OrderEntity orderEntity : orders) {
            dtos.add(OrderDto.fromOrderEntity(orderEntity));
        }
        return dtos;
    }

    @GetMapping("/orders/user/{userid}")
    @ResponseStatus(HttpStatus.OK)
    ArrayList<OrderDto> findAllOfUser(@PathVariable String userid) {
        final ArrayList<OrderEntity> orders = ordersService.findAllOf(userid);
        ArrayList<OrderDto> dtos = new ArrayList<>();
        for (OrderEntity orderEntity : orders) {
            dtos.add(OrderDto.fromOrderEntity(orderEntity));
        }
        return dtos;
    }
}
