package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrdersErrorDocumentationController {
  @GetMapping("/errors")
  @ApiOperation(value = "Retorna uma lista com todos os erros que a api pode retornar. Esse chamada está aqui apenas para documentação")
  Collection<OrderControllerException> errors() {
      return OrdersExceptionHandler.exceptionErrorMapping.values();
  }
}
