package com.project.demo.service;

import org.springframework.stereotype.Component;

import com.project.demo.dao.WishListDao;

@Component
public class UserService implements IUserService {
    private WishListDao wishListDao;

    public UserService(WishListDao wishListDao) {
        this.wishListDao = wishListDao;
    }

    public void appendWishList(int productId){
        this.wishListDao.appendProductId(productId);
    }
}
