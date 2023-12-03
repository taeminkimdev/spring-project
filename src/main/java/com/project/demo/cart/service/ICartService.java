package com.project.demo.cart.service;

import com.project.demo.cart.dto.CartDTO;

public interface ICartService {
    public CartDTO getCart(int productId, int optionId, int quantity);
}
