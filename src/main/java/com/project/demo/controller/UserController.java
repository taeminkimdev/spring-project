package com.project.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.project.demo.dto.ReqeustAppendWishList;
import com.project.demo.service.IUserService;

public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("wish-list")
    public void appendWishList(ReqeustAppendWishList req) {
        this.userService.appendWishList(req.getProductId());
    }
}
