package com.project.demo.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.product.controller.dto.ResponseProductDetailDTO;
import com.project.demo.product.controller.dto.ResponseProductsDTO;
import com.project.demo.product.service.IProductService;

@RestController
class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseProductsDTO getProducts() {
        return new ResponseProductsDTO(this.productService.getProducts());
    }

    @GetMapping("products/{productId}")
    public ResponseProductDetailDTO getProductDetail(@PathVariable("productId") int productId) {
        return new ResponseProductDetailDTO(this.productService.getProduct(productId));
    }
}