package com.project.demo.cart.infra;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.cart.dto.InfraProductDTO;

@Mapper
public interface CartProductMapper {
    @Select("SELECT id, name, price, fee, img FROM product WHERE id = #{id}")
    public InfraProductDTO findProduct(@Param("id") int id);
}
