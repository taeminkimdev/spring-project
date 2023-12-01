package com.project.demo.product.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.product.service.dto.ProductSummaryDTO;

public class ResponseProductsDTO {
    private List<ResponseProductSummaryDTO> products = new ArrayList<>();

    public ResponseProductsDTO(List<ProductSummaryDTO> products){
        for (ProductSummaryDTO productSummaryDTO : products) {
            this.products.add(
                new ResponseProductSummaryDTO(
                    productSummaryDTO.getId(), 
                    productSummaryDTO.getName(), 
                    productSummaryDTO.getPrice(), 
                    productSummaryDTO.getFee()
                )
            );
        }
    }

    public List<ResponseProductSummaryDTO> getProducts() { return this.products; }
}
