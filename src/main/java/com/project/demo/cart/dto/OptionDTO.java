package com.project.demo.cart.dto;

public class OptionDTO {
    private int id;
    private String name;
    private int quantity;
    private int totalPirce;

    public OptionDTO(int id, String name, int quantity, int totalPirce) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalPirce = totalPirce;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getQuantity() { return this.quantity; }
    public int getTotalPrice() { return this.totalPirce; }

    public void setQauntity(int quantity) { 
        int optionPrice = this.totalPirce / this.quantity;
        this.quantity = quantity;
        this.totalPirce = optionPrice * quantity;
    }

}
