package com.project.demo.cart.service;

import org.springframework.stereotype.Component;

import com.project.demo.cart.dto.CartDTO;
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

    public CartDTO getCart(int productId, int optionId, int quantity) {
        InfraProductDTO infraProductDTO = this.productMapper.findProduct(productId);
        OptionDTO option = this.optionMapper.findOption(optionId);

        ProductDTO product = new ProductDTO(
            infraProductDTO.getId(), 
            infraProductDTO.getName(), 
            infraProductDTO.getPrice(),
            infraProductDTO.getFee(), 
            infraProductDTO.getImg(), 
            option);

        return new CartDTO(IdGenerator.createId(), quantity, product);
    }
}
