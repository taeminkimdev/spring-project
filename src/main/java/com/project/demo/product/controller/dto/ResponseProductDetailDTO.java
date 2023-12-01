package com.project.demo.product.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.product.service.dto.OptionDTO;
import com.project.demo.product.service.dto.ProductDetailDTO;

public class ResponseProductDetailDTO {
    public int id;
    public String name;
    public int price;
    public int fee;
    public List<ResponseOptionDTO> options;

    public ResponseProductDetailDTO(ProductDetailDTO productDetailDTO){
        this.id = productDetailDTO.getId();
        this.name = productDetailDTO.getName();
        this.price = productDetailDTO.getPrice();
        this.fee = productDetailDTO.getFee();
        this.options = new ArrayList<>();
        for (OptionDTO optionDTO : productDetailDTO.getOptions()) {
            this.options.add(new ResponseOptionDTO(optionDTO));
        }
    }
}
