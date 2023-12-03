package com.project.demo.wishlist.dto;

public class RequestCreateWishlist {
    private int productId;

    public RequestCreateWishlist() {}

    public RequestCreateWishlist(int productId) {
        this.productId = productId;
    }

    public int getProductId() { return this.productId; }
}
