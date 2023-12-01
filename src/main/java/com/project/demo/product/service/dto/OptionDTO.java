package com.project.demo.product.service.dto;

public class OptionDTO {
    private int id;
    private int productId;
    private String name;
    private int price;

    public OptionDTO(int id, int productId, String name, int price) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getId() { return this.id; }
    public int getProductId() { return this.productId; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
}
