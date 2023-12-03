package com.project.demo.cart.service;

import com.project.demo.cart.dto.ProductDTO;

public interface ICartService {
    public ProductDTO getCart(int productId, int optionId, int quantity);
}
