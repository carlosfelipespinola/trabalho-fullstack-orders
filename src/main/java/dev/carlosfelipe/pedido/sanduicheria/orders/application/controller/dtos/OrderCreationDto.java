package dev.carlosfelipe.pedido.sanduicheria.orders.application.controller.dtos;

import java.util.ArrayList;

import org.springframework.boot.jackson.JsonComponent;

import dev.carlosfelipe.pedido.sanduicheria.orders.domain.OrderProductEntity;
import dev.carlosfelipe.pedido.sanduicheria.orders.domain.PaymentCreditCard;

@JsonComponent
public class OrderCreationDto {
    private String user;
    private String creditCardOwner;
    private String creditCardNumber;
    private String creditCardCvv;
    private String creditCardExpirationMonthYear;
    private ArrayList<ProductDto> products;

    public OrderCreationDto() {};
    
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
        return new PaymentCreditCard(
            creditCardCvv,
            creditCardExpirationMonthYear,
            creditCardNumber,
            creditCardOwner
        );
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreditCardOwner() {
        return creditCardOwner;
    }

    public void setCreditCardOwner(String creditCardOwner) {
        this.creditCardOwner = creditCardOwner;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardCvv() {
        return creditCardCvv;
    }

    public void setCreditCardCvv(String creditCardCvv) {
        this.creditCardCvv = creditCardCvv;
    }

    public String getCreditCardExpirationMonthYear() {
        return creditCardExpirationMonthYear;
    }

    public void setCreditCardExpirationMonthYear(String creditCardExpirationMonthYear) {
        this.creditCardExpirationMonthYear = creditCardExpirationMonthYear;
    }

    public ArrayList<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDto> products) {
        this.products = products;
    };

    
}
