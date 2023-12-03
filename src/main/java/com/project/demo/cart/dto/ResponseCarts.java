package com.project.demo.cart.dto;

import java.util.List;

public class ResponseCarts {
    private List<CartDTO> carts;

    public ResponseCarts(List<CartDTO> carts){
        this.carts = carts;
    }

    public List<CartDTO> getCarts() { return this.carts; }
}
