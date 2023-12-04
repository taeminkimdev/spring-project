package com.project.demo.cart.service;

import com.project.demo.cart.dto.ProductDTO;
import com.project.demo.exceptions.NotExistResource;

public interface ICartService {
    public ProductDTO getCart(int productId, int optionId, int quantity) throws NotExistResource;
}
