package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderInvalidException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.OrderNotFoundException;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.exceptions.PaymentException;

import static java.util.Map.entry; 


@RestControllerAdvice
public class OrdersExceptionHandler extends ResponseEntityExceptionHandler {

  public static final Map<Class<? extends Exception>, OrderControllerException> exceptionErrorMapping = Map.ofEntries(
    entry(OrderNotFoundException.class, new OrderControllerException("Pedido não encontrado", "order-not-found-error", HttpStatus.NOT_FOUND)),
    entry(OrderInvalidException.class, new OrderControllerException("Pedido inválido", "order-invalid-error", HttpStatus.BAD_REQUEST)),
    entry(PaymentException.class, new OrderControllerException("Ocorreu um erro ao processar pagamento", "payment-error", HttpStatus.PAYMENT_REQUIRED)),
    entry(OrderException.class, new OrderControllerException("Ocorreu um erro ao processar pedido", "internal-error", HttpStatus.INTERNAL_SERVER_ERROR))
  );

  @ExceptionHandler(value = {OrderException.class, PaymentException.class})
  @PostMapping
  public ResponseEntity<Object> handleExceptions(OrderException exception, WebRequest webRequest) {
    OrderControllerException response = exceptionErrorMapping.get(exception.getClass());
    if (response == null) {
      response = exceptionErrorMapping.get(OrderException.class);
    }
    ResponseEntity<Object> entity = new ResponseEntity<>(response, response.getStatus());
    return entity;
  }
}
