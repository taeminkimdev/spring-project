package com.project.demo.wishlist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.demo.auth.domain.User;
import com.project.demo.wishlist.dto.ResponseIsExist;
import com.project.demo.wishlist.dto.ResponseWishlist;
import com.project.demo.wishlist.service.IWishlistService;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class WishlistController {
    private IWishlistService wishlistService;
    
    public WishlistController(IWishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("wishlist")
    public ResponseWishlist getWishlist(HttpSession session) {
        User user = (User)session.getAttribute("user");
        ResponseWishlist res = new ResponseWishlist(this.wishlistService.getWishlist(user.getId()));
        return res;
    }

    @PostMapping("wishlist")
    public void createWishlist(HttpSession session, int productId) {
        User user = (User)session.getAttribute("user");
        this.wishlistService.appendWishlist(user.getId(), productId);
    }

    @GetMapping("wishlist/{productId}")
    public ResponseIsExist CheckDuplication(HttpSession session, @PathVariable("productId") int productId){
        User user = (User)session.getAttribute("user");
        boolean isExist = this.wishlistService.isExistWishlist(user.getId(), productId);
        return new ResponseIsExist(isExist);
    }

    @DeleteMapping("wishlist/{productId}")
    public void deleteWishlist(HttpSession session, @PathVariable("productId") int productId) {
        User user = (User)session.getAttribute("user");
        this.wishlistService.deleteWishlist(user.getId(), productId);
    }
}
