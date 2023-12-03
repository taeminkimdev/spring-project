package com.project.demo.cart.infra;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.cart.dto.InfraOptionDTO;

@Mapper
public interface CartOptionMapper {
    @Select("SELECT id, name, price FROM optiontable WHERE id = #{id}")
    public InfraOptionDTO findOption(@Param("id") int id);
}
