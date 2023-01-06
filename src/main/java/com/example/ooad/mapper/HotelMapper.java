package com.example.ooad.mapper;

import com.example.ooad.enity.Hotel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelMapper {

    @Select("select * from \"Hotel\"")
    public List<Hotel> findAllHotel();

    @Insert("INSERT INTO \"Hotel\" (id, name, grade, location, city, district, remark, \"graphPath\") VALUES (DEFAULT, #{name}, #{grade},#{location},#{city},#{district},#{remark}, #{graphPath})")
    public int insert(Hotel hotel);

    @Select("select * from \"Hotel\" where grade = #{grade} and city = #{city} and district = #{district}")
    public List<Hotel> findHotels(@Param("grade") Integer grade, String city, String district);

    @Select("select * from \"Hotel\" where city = #{city}")
    public List<Hotel> findHotelsByCity(String city);

    @Select("select min(price * discount) from (select room_type from \"Room\" where h_id = #{h_id}) as a inner join \"RoomType\" on \"RoomType\".room_type = a.room_type")
    public Integer findLow(Integer h_id);

    @Select("select * from(select min(price * discount)as price, a.h_id from (select * from (select id from \"Hotel\" where grade = #{grade} and city = #{city} and district = #{district})as b inner join \"Room\" on b.id=\"Room\".h_id) as a inner join \"RoomType\" on \"RoomType\".room_type = a.room_type group by a.h_id) as c inner join \"Hotel\" on (c.price between #{low} and #{high}) and \"Hotel\".id = c.h_id;")
    public List<Hotel> findByPrice(Integer grade, String city, String district, Integer low, Integer high);



}
