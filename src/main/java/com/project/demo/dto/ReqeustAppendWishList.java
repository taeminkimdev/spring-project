package com.project.demo.dto;

public class ReqeustAppendWishList {
    private int productId;

    public ReqeustAppendWishList(int productId){
        this.productId = productId;
    }

    public int getProductId(){return this.productId;}
}
