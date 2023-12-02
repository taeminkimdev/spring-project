package com.project.demo.product.service;
import java.util.*;

import com.project.demo.product.dto.ProductDetailDTO;
import com.project.demo.product.dto.ProductDTO;


public interface IProductService {
    public List<ProductDTO> getProducts();
    public ProductDetailDTO getProduct(int id);
}
