package com.project.demo.product.dto;

import java.util.List;

public class ResponseProducts {
    private List<ProductDTO> products;

    public ResponseProducts(List<ProductDTO> productDTOs){
        this.products = productDTOs;
    }

    public List<ProductDTO> getProducts() { return this.products; }
}
