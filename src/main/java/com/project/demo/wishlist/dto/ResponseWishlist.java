package com.project.demo.wishlist.dto;

import java.util.List;

public class ResponseWishlist {
    private List<WishlistDTO> wishlist;

    public ResponseWishlist(List<WishlistDTO> wishlist) {
        this.wishlist = wishlist;
    }

    public List<WishlistDTO> getWishlist() { return this.wishlist; }
}
