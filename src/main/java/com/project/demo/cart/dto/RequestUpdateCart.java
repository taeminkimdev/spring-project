package com.project.demo.cart.dto;

public class RequestUpdateCart {
    private int quantity;

    public RequestUpdateCart() {}
    public RequestUpdateCart(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() { return this.quantity; }
}
