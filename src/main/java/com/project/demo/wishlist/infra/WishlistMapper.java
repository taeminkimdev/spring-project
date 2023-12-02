package com.project.demo.wishlist.infra;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.wishlist.dto.WishlistDTO;

@Mapper
public interface WishlistMapper {
    @Insert("INSERT INTO wishlist (userId, productId) VALUE(#{userId}, #{productId})")
    public void insertWishlist(@Param("userId") int userId, @Param("productId") int productId);

    @Select("SELECT id, name, price, fee, img FROM wishlist w INNER JOIN product p ON w.productId = p.id WHERE userId = #{userId}")
    public List<WishlistDTO> findWishlists(@Param("userId") int userId);

    @Select("SELECT productId FROM wishlist WHERE userId = #{userId} and productId = #{productId}")
    public Integer findWishlist(@Param("userId") int userId, @Param("productId") int productId);

    @Delete("DELETE FROM wishlist WHERE userId = #{userId} and productId = #{productId}")
    public void deleteWishlist(@Param("userId") int userId, @Param("productId") int productId);
}
