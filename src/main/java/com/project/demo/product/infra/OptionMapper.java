package com.project.demo.product.infra;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.product.dto.OptionDTO;

@Mapper
public interface OptionMapper {
    @Select("SELECT id, name, price FROM optiontable WHERE productId = #{productId}")
    List<OptionDTO> findOptionsByProductId(@Param("productId") int productId);
}
