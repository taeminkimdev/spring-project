package com.project.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.Product;
import com.project.demo.dto.Products;
import com.project.demo.service.IProductService;

@RestController
class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("products")
    public Products getProducts() {
        return new Products(this.productService.getProducts());
    }

    @GetMapping("products/{productId}")
    public Product getProductDetail(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }
}