package com.project.demo.product.controller.dto;

import com.project.demo.product.service.dto.OptionDTO;

public class ResponseOptionDTO {
    private int id;
    private int productId;
    private String name;
    private int price;

    public ResponseOptionDTO(OptionDTO optionDTO) {
        this.id = optionDTO.getId();
        this.productId = optionDTO.getProductId();
        this.name = optionDTO.getName();
        this.price = optionDTO.getPrice();
    }

    public int getId() { return this.id; }
    public int getProductId() { return this.productId; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
}
