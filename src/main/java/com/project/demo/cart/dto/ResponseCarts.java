package com.project.demo.cart.dto;

import java.util.List;

public class ResponseCarts {
    private int totalPirce;
    private List<ProductDTO> carts;

    public ResponseCarts(List<ProductDTO> carts, int totalPirce){
        this.totalPirce = totalPirce;
        this.carts = carts;
    }

    public int getTotalPrice() { return this.totalPirce; }
    public List<ProductDTO> getCarts() { return this.carts; }
}
