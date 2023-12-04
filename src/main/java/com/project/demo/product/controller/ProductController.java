package com.project.demo.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.product.dto.ProductDetailDTO;
import com.project.demo.product.dto.ResponseProducts;
import com.project.demo.product.service.IProductService;
import com.project.demo.util.IdGenerator;

@RestController
class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseProducts getProducts() {
        System.out.println(IdGenerator.createId());
        return new ResponseProducts(this.productService.getProducts());
    }

    @GetMapping("products/{productId}")
    public ProductDetailDTO getProductDetail(@PathVariable("productId") int productId) {
        return this.productService.getProduct(productId);
    }
}