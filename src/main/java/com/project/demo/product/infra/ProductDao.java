package com.project.demo.product.infra;
import java.util.*;

import org.springframework.stereotype.Component;

import com.project.demo.product.infra.dataSource.OptionMapper;
import com.project.demo.product.infra.dataSource.ProductMapper;
import com.project.demo.product.infra.dataSource.dto.DataSourceOptionDTO;
import com.project.demo.product.infra.dataSource.dto.DataSourceProductDetailDTO;
import com.project.demo.product.infra.dataSource.dto.DataSourceProductSummaryDTO;
import com.project.demo.product.infra.dto.InfraOptionDTO;
import com.project.demo.product.infra.dto.InfraProductDetailDTO;
import com.project.demo.product.infra.dto.InfraProductSummaryDTO;

@Component
public class ProductDao {
    private ProductMapper productMapper;
    private OptionMapper optionMapper;

    public ProductDao(ProductMapper productMapper, OptionMapper optionMapper) {
        this.productMapper = productMapper;
        this.optionMapper = optionMapper;
    }
    public List<InfraProductSummaryDTO> findProducts(){
        List<InfraProductSummaryDTO> products = new ArrayList<>();
        for (DataSourceProductSummaryDTO productDTO : this.productMapper.findProducts()) {
            products.add(new InfraProductSummaryDTO(productDTO.getId(), productDTO.getName(), productDTO.getPrice(), productDTO.getFee()));
        }
        return products;
    }

    public InfraProductDetailDTO findProduct(int id) {
        DataSourceProductDetailDTO productDetailDTO = this.productMapper.findProduct(id);
        List<InfraOptionDTO> optionsDTO = new ArrayList<>();
        for (DataSourceOptionDTO optionDTO : this.optionMapper.findOptionsByProductId(id)) {
            optionsDTO.add(new InfraOptionDTO(optionDTO.getId(), optionDTO.getProductId(), optionDTO.getName(), optionDTO.getPrice()));
        }
        return new InfraProductDetailDTO(
            productDetailDTO.getId(), 
            productDetailDTO.getName(), 
            productDetailDTO.getPrice(), 
            productDetailDTO.getFee(),
            optionsDTO);
    }
}
