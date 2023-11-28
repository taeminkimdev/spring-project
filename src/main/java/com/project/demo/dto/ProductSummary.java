package com.project.demo.dto;

public class ProductSummary {
    public int id;
    public String name;
    public int price;
    public int fee;

    public ProductSummary(int id, String name, int price, int fee){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
    }
}
