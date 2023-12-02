package com.project.demo.product.service;
import com.project.demo.product.dto.ProductDetailDTO;
import com.project.demo.product.dto.OptionDTO;
import com.project.demo.product.dto.ProductDTO;
import com.project.demo.product.infra.OptionMapper;
import com.project.demo.product.infra.ProductMapper;
import com.project.demo.product.service.IProductService;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImp implements IProductService{
    private ProductMapper productMapper;
    private OptionMapper optionMapper;

    public ProductServiceImp(ProductMapper productMapper, OptionMapper optionMapper){
        this.productMapper = productMapper;
        this.optionMapper = optionMapper;
    }

    public List<ProductDTO> getProducts(){
        return this.productMapper.findProducts();
    }

    public ProductDetailDTO getProduct(int id) {
        ProductDTO productDTO = this.productMapper.findProduct(id);
        List<OptionDTO> options = this.optionMapper.findOptionsByProductId(id);

        return new ProductDetailDTO(productDTO, options);
    }
}
