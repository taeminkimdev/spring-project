package com.project.demo.product.service.dto;

import java.util.List;

public class ProductDetailDTO {
    private int id;
    private String name;
    private int price;
    private int fee;
    private List<OptionDTO> options;

    public ProductDetailDTO(int id, String name, int price, int fee, List<OptionDTO> options){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
        this.options = options;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getFee() { return this.fee; }
    public List<OptionDTO> getOptions() { return this.options; }
}
