package com.example.ooad.mapper;

import com.example.ooad.enity.Room;
import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Select("select * from \"Room\"")
    public List<Room> findAllRoom();

    @Insert("insert into \"Room\" (id, \"HotelName\", \"RoomNumber\", \"graphPath\", h_id, room_type) VALUES (DEFAULT, #{HotelName}, #{RoomNumber}, #{graphPath},#{h_id},#{room_type})")
    public int insert(Room room);

    @Delete("DELETE FROM public.\"Room\" WHERE id = #{id}")
    public int delete(Integer id);

    @Update("UPDATE public.\"Room\" SET \"HotelName\" = #{HotelName}, \"RoomNumber\" = #{RoomNumber}, \"graphPath\" = #{graphPath}, h_id = #{h_id}, room_type = #{room_type} WHERE id = #{id}")
    public Integer update(Room room);

    @Select("select * from \"Room\" where h_id = #{h_id}")
    public List<Room> findRooms(@Param("h_id")Integer h_id);

    @Select("select * from public.\"Room\" where h_id = #{h_id} and public.\"Room\".\"RoomNumber\" = #{RoomNumber}")
    public List<Room> findtheroom(Integer h_id,Integer RoomNumber);

    @Select("select *  from (select h_id,\"RoomNumber\" from \"order\" where (\"EndData\" < current_timestamp)) " +
            "as a inner join \"Room\" on \"Room\".h_id= a.h_id and \"Room\".\"RoomNumber\"=a.\"RoomNumber\"")
    public List<Room> findAllCurrentRooms();

    @Select("select *  from (select h_id,\"RoomNumber\" from \"order\" where (\"EndData\" < current_timestamp)) " +
            "as a inner join \"Room\" on #{h_id}= a.h_id and \"Room\".\"RoomNumber\"=a.\"RoomNumber\"")
    public List<Room> findCurrentRooms(Integer h_id);






}
