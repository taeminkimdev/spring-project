package com.project.demo.product.service;
import com.project.demo.product.infra.ProductDao;
import com.project.demo.product.infra.dto.InfraOptionDTO;
import com.project.demo.product.infra.dto.InfraProductDetailDTO;
import com.project.demo.product.infra.dto.InfraProductSummaryDTO;
import com.project.demo.product.service.IProductService;
import com.project.demo.product.service.dto.OptionDTO;
import com.project.demo.product.service.dto.ProductDetailDTO;
import com.project.demo.product.service.dto.ProductSummaryDTO;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImp implements IProductService{
    private ProductDao productDao;

    public ProductServiceImp(ProductDao productDao){
        this.productDao = productDao;
    }

    public List<ProductSummaryDTO> getProducts(){
        List<ProductSummaryDTO> products = new ArrayList<>();
        for (InfraProductSummaryDTO productSummaryDTO : this.productDao.findProducts()) {
            products.add(
                new ProductSummaryDTO(
                    productSummaryDTO.getId(), 
                    productSummaryDTO.getName(), 
                    productSummaryDTO.getPrice(), 
                    productSummaryDTO.getFee()));
        }
        return products;
    }

    public ProductDetailDTO getProduct(int id) {
        InfraProductDetailDTO infraProduct = this.productDao.findProduct(id);
        List<OptionDTO> options = new ArrayList<>();
        for (InfraOptionDTO optionDTO : infraProduct.getOptions()) {
            options.add(new OptionDTO(optionDTO.getId(), optionDTO.getProductId(), optionDTO.getName(), optionDTO.getPrice()));
        }
        return new ProductDetailDTO(
            infraProduct.getId(), 
            infraProduct.getName(), 
            infraProduct.getPrice(), 
            infraProduct.getFee(), 
            options);
    }
}
