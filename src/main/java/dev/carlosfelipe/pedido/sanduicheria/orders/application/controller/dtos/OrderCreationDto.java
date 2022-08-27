package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.PaymentCreditCard;


public class OrderCreationDto {
    public String user;
    public String creditCardOwner;
    public String creditCardNumber;
    public String creditCardCvv;
    public String creditCardExpirationDateIso8601;
    public ArrayList<ProductDto> products;
    
    public OrderCreationDto(String user, ArrayList<ProductDto> products) {
        this.user = user;
        this.products = products;
    }

    public ArrayList<OrderProductEntity> getProductEntities() {
        ArrayList<OrderProductEntity> _products = new ArrayList<>(products.size());
        for (ProductDto product : products) {
            _products.add(product.tOrderProductEntity());
        }
        return _products;
    };

    public PaymentCreditCard getPaymentMethod() {
        OffsetDateTime date = OffsetDateTime.parse(creditCardExpirationDateIso8601);
        return new PaymentCreditCard(
            creditCardCvv,
            date,
            creditCardNumber,
            creditCardOwner
        );
    };
}
