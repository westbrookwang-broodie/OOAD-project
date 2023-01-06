package com.example.ooad.mapper;
import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.User;
import com.example.ooad.enity.favorites;
import com.example.ooad.enity.evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface     favoritesMapper {
    @Insert("INSERT INTO favorites (username, h_id) VALUES (#{username}, #{h_id})")
    public int insert(String username, Integer h_id);

    @Select("select * from (select h_id from favorites where username=#{username}) as a inner join \"Hotel\" on h_id=\"Hotel\".id")
    public List<Hotel> hotels(String username);

    @Delete("DELETE FROM \"favorites\" where username = #{username} and h_id = #{h_id}")
    public Integer delete(String username, Integer h_id);

    @Select("select * from favorites where h_id=#{h_id} and username=#{username}")
    public List<favorites> favs(String username, Integer h_id);
}
