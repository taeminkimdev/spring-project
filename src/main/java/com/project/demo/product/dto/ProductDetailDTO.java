package com.project.demo.product.dto;

import java.util.List;

public class ProductDetailDTO {
    private int id;
    private String name;
    private int price;
    private int fee;
    private String img;
    private List<OptionDTO> options;

    public ProductDetailDTO(ProductDTO productDTO, List<OptionDTO> options){
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.fee = productDTO.getFee();
        this.img = productDTO.getImg();
        this.options = options;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getFee() { return this.fee; }
    public String getImg() { return this.img; }
    public List<OptionDTO> getOptions() { return this.options; }
}
