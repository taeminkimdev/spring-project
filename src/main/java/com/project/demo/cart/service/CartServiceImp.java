package com.project.demo.cart.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.cart.dto.InfraOptionDTO;
import com.project.demo.cart.dto.InfraProductDTO;
import com.project.demo.cart.dto.OptionDTO;
import com.project.demo.cart.dto.ProductDTO;
import com.project.demo.cart.infra.CartOptionMapper;
import com.project.demo.cart.infra.CartProductMapper;
import com.project.demo.util.IdGenerator;

@Component
public class CartServiceImp implements ICartService{
    private CartProductMapper productMapper;
    private CartOptionMapper optionMapper;

    public CartServiceImp(CartProductMapper productMapper, CartOptionMapper optionMapper){
        this.productMapper = productMapper;
        this.optionMapper = optionMapper;    
    }

    public ProductDTO getCart(int productId, int optionId, int quantity) {
        InfraProductDTO infraProductDTO = this.productMapper.findProduct(productId);
        InfraOptionDTO infraOptionDTO = this.optionMapper.findOption(optionId);

        int totalPrice = infraOptionDTO.getPrice() * quantity;

        OptionDTO option = new OptionDTO(
            infraOptionDTO.getId(),
            infraOptionDTO.getName(),
            quantity,
            totalPrice);

        ProductDTO product = new ProductDTO(
            infraProductDTO.getId(), 
            infraProductDTO.getName(), 
            infraProductDTO.getPrice(),
            infraProductDTO.getFee(), 
            infraProductDTO.getImg(), 
            List.of(option));

        return product;
    }
}
