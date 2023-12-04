package com.project.demo.wishlist.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.wishlist.dto.WishlistDTO;
import com.project.demo.wishlist.infra.WishlistMapper;

@Component
public class WishlistServiceImp implements IWishlistService{
    private WishlistMapper wishlistMapper;

    public WishlistServiceImp(WishlistMapper wishlistMapper) {
        this.wishlistMapper = wishlistMapper;
    } 

    public List<WishlistDTO> getWishlist(int userId) {
        return this.wishlistMapper.findWishlists(userId);
    }

    public void appendWishlist(int userId, int productId) {
        this.wishlistMapper.insertWishlist(userId, productId);
    }

    public boolean isExistWishlist(int userId, int productId) {
        Integer result = this.wishlistMapper.findWishlist(userId, productId);
        return result != null;
    }

    public void deleteWishlist(int userId, int productId) {
        this.wishlistMapper.deleteWishlist(userId, productId);
    }
}
