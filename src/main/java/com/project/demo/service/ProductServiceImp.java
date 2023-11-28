package com.project.demo.service;
import com.project.demo.service.IProductService;
import com.project.demo.dao.ProductDao;
import com.project.demo.dto.Product;
import com.project.demo.dto.ProductSummary;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImp implements IProductService{
    private final ProductDao productDao;

    public ProductServiceImp(ProductDao productDao){
        this.productDao = productDao;
    }

    public List<ProductSummary> getProducts(){
        return productDao.findProducts();
    }

    public Product getProduct(int id) {
        return productDao.findProduct(id);
    }
}
