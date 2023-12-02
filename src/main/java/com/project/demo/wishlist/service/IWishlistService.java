package com.project.demo.wishlist.service;

import java.util.List;

import com.project.demo.wishlist.dto.WishlistDTO;

public interface IWishlistService {
    public List<WishlistDTO> getWishlist(int userId);
    public void appendWishlist(int userId, int productId);
    public void deleteWishlist(int userId, int productId);
    public boolean isExistWishlist(int userId, int productId);
}
