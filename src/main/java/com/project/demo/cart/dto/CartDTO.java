package com.project.demo.cart.dto;

public class CartDTO {
    private int id;
    private int quantity;
    private ProductDTO product;

    public CartDTO(int id, int quantity, ProductDTO product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() { return this.id; }
    public int getQuantity() { return this.quantity; }
    public ProductDTO getProduct() { return this.product; }
}
