package com.project.demo.cart.dto;

public class RequestAppendCart {
    private int productId;
    private int optionId;
    private int quantity;

    public RequestAppendCart() {}
    public RequestAppendCart(int productId, int optionId, int quantity) {
        this.productId = productId;
        this.optionId = optionId;
        this.quantity = quantity;
    }

    public int getProductId() { return this.productId; }
    public int getOptionId() { return this.optionId; }
    public int getQuantity() { return this.quantity; }

}
