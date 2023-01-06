package com.example.ooad.mapper;

import com.example.ooad.enity.Room;
import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.RoomType;
import com.example.ooad.enity.order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomTypeMapper {

    @Select("select * from \"RoomType\"")
    public List<RoomType> findAllRoomType();
    @Select("select * from \"RoomType\" where room_type = #{room_type}")
    public List<RoomType> findAllRoomTypes(String room_type);

    @Select("select * from \"RoomType\" where room_type = #{room_type}")
    public List<RoomType> findsome(String room_type);

    @Insert("insert into \"RoomType\" (id, \"room_type\", \"area\", \"bed_number\", \"price\",\"discount\", \"kind\") VALUES (DEFAULT, #{room_type}, #{area}, #{bed_number},#{price},#{discount},#{kind})")
    public int insert(RoomType roomtype);

    @Delete("DELETE FROM public.\"RoomType\" WHERE id = #{id}")
    public int delete(Integer id);

    @Update("UPDATE public.\"RoomType\" SET \"room_type\" = #{room_type}, \"area\" = #{area}, \"bed_number\" = #{bed_number}, price = #{price}, discount = #{discount}, kind = #{kind} WHERE id = #{id}")
    public Integer update(RoomType roomType);







}
