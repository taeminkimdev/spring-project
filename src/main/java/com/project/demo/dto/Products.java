package com.project.demo.dto;
import java.util.*;

public class Products {
    public List<ProductSummary> products;

    public Products(List<ProductSummary> products){
        this.products = products;
    }
}