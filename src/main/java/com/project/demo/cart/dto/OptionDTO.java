package com.project.demo.cart.dto;

public class OptionDTO {
    private int id;
    private String name;
    private int pirce;

    public OptionDTO(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.pirce = price;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.pirce; }
}
