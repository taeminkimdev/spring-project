package com.project.demo.cart.dto;

public class InfraOptionDTO {
    private int id;
    private String name;
    private int price;

    public InfraOptionDTO(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
}
