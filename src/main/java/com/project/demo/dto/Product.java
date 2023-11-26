package com.project.demo.dto;
import java.util.*;
import com.project.demo.dto.Option;

public class Product {
    public int id;
    public String name;
    public int price;
    public int fee;
    public List<Option> options;

    public Product(int id, String name, int price, int fee, List<Option> options){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fee = fee;
        this.options = options;
    }
}
