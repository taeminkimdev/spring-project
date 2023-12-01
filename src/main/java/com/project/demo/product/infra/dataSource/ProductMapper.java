package com.project.demo.product.infra.dataSource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.product.infra.dataSource.dto.DataSourceProductDetailDTO;
import com.project.demo.product.infra.dataSource.dto.DataSourceProductSummaryDTO;

@Mapper
public interface ProductMapper {
    @Select("SELECT id, name, price, fee FROM product")
    List<DataSourceProductSummaryDTO> findProducts();

    @Select("SELECT id, name, price, fee FROM product WHERE id = #{id}")
    DataSourceProductDetailDTO findProduct(@Param("id") int id);
}
