package com.project.demo.cart.dto;

import java.util.List;

public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int fee;
    private String img;
    private List<OptionDTO> option;

    public ProductDTO(int id, String name, int price, int fee, String img, List<OptionDTO> option) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
        this.img = img;
        this.option = option;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getFee() { return this.fee; }
    public String getImg() { return this.img; }
    public List<OptionDTO> getOption() { return this.option; }
}
