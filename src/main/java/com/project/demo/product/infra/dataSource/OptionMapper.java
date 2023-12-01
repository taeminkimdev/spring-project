package com.project.demo.product.infra.dataSource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.product.infra.dataSource.dto.DataSourceOptionDTO;

@Mapper
public interface OptionMapper {
    @Select("SELECT id, productId, name, price FROM optiontable WHERE productId = #{productId}")
    List<DataSourceOptionDTO> findOptionsByProductId(@Param("productId") int productId);
}
