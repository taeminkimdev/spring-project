package com.project.demo.product.infra;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.product.dto.ProductDTO;

@Mapper
public interface ProductMapper {
    @Select("SELECT id, name, price, fee, img FROM product")
    List<ProductDTO> findProducts();

    @Select("SELECT id, name, price, fee, img FROM product WHERE id = #{id}")
    ProductDTO findProduct(@Param("id") int id);
}
