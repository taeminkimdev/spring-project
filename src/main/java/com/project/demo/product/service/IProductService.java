package com.project.demo.product.service;
import java.util.*;

import com.project.demo.product.service.dto.ProductDetailDTO;
import com.project.demo.product.service.dto.ProductSummaryDTO;

public interface IProductService {
    public List<ProductSummaryDTO> getProducts();
    public ProductDetailDTO getProduct(int id);
}
