package com.project.demo.wishlist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.demo.auth.domain.User;
import com.project.demo.exceptions.NotAllowedUser;
import com.project.demo.wishlist.dto.RequestCreateWishlist;
import com.project.demo.wishlist.dto.ResponseIsExist;
import com.project.demo.wishlist.dto.ResponseWishlist;
import com.project.demo.wishlist.service.IWishlistService;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class WishlistController {
    private IWishlistService wishlistService;
    
    public WishlistController(IWishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("wishlist")
    public ResponseWishlist getWishlist(HttpSession session) throws NotAllowedUser {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            throw new NotAllowedUser();
        }
        ResponseWishlist res = new ResponseWishlist(this.wishlistService.getWishlist(user.getId()));
        return res;
    }

    @PostMapping("wishlist")
    public void createWishlist(HttpSession session, @RequestBody RequestCreateWishlist req) throws NotAllowedUser{
        User user = (User)session.getAttribute("user");
        if(user == null) {
            throw new NotAllowedUser();
        }
        this.wishlistService.appendWishlist(user.getId(), req.getProductId());
    }

    @GetMapping("wishlist/{productId}")
    public ResponseIsExist CheckDuplication(HttpSession session, @PathVariable("productId") int productId) throws NotAllowedUser{
        User user = (User)session.getAttribute("user");
        if(user == null) {
            throw new NotAllowedUser();
        }

        boolean isExist = this.wishlistService.isExistWishlist(user.getId(), productId);
        return new ResponseIsExist(isExist);
    }

    @DeleteMapping("wishlist/{productId}")
    public void deleteWishlist(HttpSession session, @PathVariable("productId") int productId) throws NotAllowedUser{
        User user = (User)session.getAttribute("user");
        if(user == null) {
            throw new NotAllowedUser();
        }
        this.wishlistService.deleteWishlist(user.getId(), productId);
    }
}
