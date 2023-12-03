package com.project.demo.cart.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.demo.cart.dto.OptionDTO;
import com.project.demo.cart.dto.ProductDTO;
import com.project.demo.cart.dto.RequestAppendCart;
import com.project.demo.cart.dto.RequestUpdateCart;
import com.project.demo.cart.dto.ResponseCarts;
import com.project.demo.cart.service.ICartService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        List<ProductDTO> carts = (List<ProductDTO>)session.getAttribute("cart");
        if(carts == null) {
            carts = new ArrayList<>();
            session.setAttribute("cart", carts);
        }

        int totalPirce = 0;
        for (ProductDTO cart : carts) {
            totalPirce += cart.getOption().get(0).getTotalPrice();
        }

        return new ResponseCarts(carts, totalPirce);
    }

    @PostMapping("cart")
    public void appendCart(HttpSession session, @RequestBody RequestAppendCart req) {
        ProductDTO cart = this.cartService.getCart(req.getProductId(), req.getOptionId(), req.getQuantity());
        
        List<ProductDTO> carts = (List<ProductDTO>)session.getAttribute("cart");
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
    
    @DeleteMapping("cart/{productId}")
    public void deleteCart(HttpSession session, @PathVariable("productId") int productId) {
        List<ProductDTO> carts = (List<ProductDTO>)session.getAttribute("cart");
        for (ProductDTO cart : carts) {
            if(productId == cart.getId()) {
                carts.remove(cart);
                session.setAttribute("cart", carts);
                return;
            }
        }
    }

    @PatchMapping("cart/{productId}/{optionId}")
    public void updateCartOption(HttpSession session, @PathVariable("productId") int productId, @PathVariable("optionId") int optionId, @RequestBody RequestUpdateCart req) {
        List<ProductDTO> carts = (List<ProductDTO>)session.getAttribute("cart");
        for (ProductDTO cart : carts) {
            if(productId == cart.getId() && optionId == cart.getOption().get(0).getId()) {
                cart.getOption().get(0).setQauntity(req.getQuantity());
                session.setAttribute("cart", carts);
                return;
            }
        }
    }
}
