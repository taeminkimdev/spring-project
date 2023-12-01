package com.project.demo.product.service.dto;


public class ProductSummaryDTO {
    private int id;
    private String name;
    private int price;
    private int fee;

    public ProductSummaryDTO(int id, String name, int price, int fee){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getFee() { return this.fee; }

}