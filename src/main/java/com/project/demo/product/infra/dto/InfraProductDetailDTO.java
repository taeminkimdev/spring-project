package com.project.demo.product.infra.dto;

import java.util.List;

public class InfraProductDetailDTO {
    private int id;
    private String name;
    private int price;
    private int fee;
    private List<InfraOptionDTO> options;

    public InfraProductDetailDTO(int id, String name, int price, int fee, List<InfraOptionDTO> options){
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
    public List<InfraOptionDTO> getOptions() { return this.options; }
}
