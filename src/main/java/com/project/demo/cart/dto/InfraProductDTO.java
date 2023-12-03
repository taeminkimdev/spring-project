package com.project.demo.cart.dto;

public class InfraProductDTO {
    private int id;
    private String name;
    private int price;
    private int fee;
    private String img;

    public InfraProductDTO(int id, String name, int price, int fee, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
        this.img = img;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getFee() { return this.fee; }
    public String getImg() { return this.img; }
}
