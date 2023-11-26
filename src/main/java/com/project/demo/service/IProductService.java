package com.project.demo.service;
import java.util.*;

import com.project.demo.dto.Product;
import com.project.demo.dto.ProductSummary;

public interface IProductService {
    public List<ProductSummary> getProducts();
    public Product getProduct(int id);
}
