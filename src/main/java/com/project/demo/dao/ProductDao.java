package com.project.demo.dao;
import java.util.*;

import org.springframework.stereotype.Component;

import com.project.demo.dto.Product;
import com.project.demo.dto.ProductSummary;
import com.project.demo.dto.Option;

@Component
public class ProductDao {
    public List<ProductSummary> findProducts(){
        return List.of( 
            new ProductSummary(1, "감자", 3000, 2000),  
            new ProductSummary(2, "과자", 5000, 2000),
            new ProductSummary(3, "계좌", 1000, 2000),
            new ProductSummary(4, "겐지", 3000, 2000)
        );
    }

    public Product findProduct(int id) {
        List<Option> options = List.of(new Option(1, "대", 1000), new Option(2, "중", 500), new Option(3, "소", 100));
        return new Product(1, "감자", 3000, 2000, options);
    }
}
