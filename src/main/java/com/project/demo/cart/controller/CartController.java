package com.project.demo.cart.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.demo.cart.dto.CartDTO;
import com.project.demo.cart.dto.RequestAppendCart;
import com.project.demo.cart.dto.ResponseCarts;
import com.project.demo.cart.service.ICartService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CartController {
    private ICartService cartService;

    public CartController(ICartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("cart")
    public ResponseCarts getCart(HttpSession session) {
        List<CartDTO> carts = (List<CartDTO>)session.getAttribute("cart");
        if(carts == null) {
            carts = new ArrayList<>();
            session.setAttribute("cart", carts);
        }
        return new ResponseCarts(carts);
    }

    @PostMapping("cart")
    public void appendCart(HttpSession session, @RequestBody RequestAppendCart req) {
        CartDTO cart = this.cartService.getCart(req.getProductId(), req.getOptionId(), req.getQuantity());
        
        List<CartDTO> carts = (List<CartDTO>)session.getAttribute("cart");
        if(carts == null) {
            carts = new ArrayList<>();
            carts.add(cart);
            session.setAttribute("cart", carts);
            return;
        }

        carts.add(cart);
        session.setAttribute("cart", carts);
        return;
    }
    
    @DeleteMapping("cart/{id}")
    public void deleteCart(HttpSession session, @PathVariable("id") int id) {
        List<CartDTO> carts = (List<CartDTO>)session.getAttribute("cart");
        for (CartDTO cart : carts) {
            if(id == cart.getId()) {
                carts.remove(cart);
                session.setAttribute("cart", carts);
                return;
            }
        }
    }
}
