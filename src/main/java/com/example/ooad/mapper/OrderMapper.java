package com.example.ooad.mapper;
import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.order;
import com.example.ooad.controller.RoomTypePrice;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from \"order\"")
    public List<order> findAllOrder();

//    @Insert("insert into \"order\" (\"HotelName\", \"RoomNumber\", username, price, \"BeginData\", \"EndData\", h_id)")
//    public int insert(order order);

    @Select("select * from \"order\" where h_id=#{h_id}")
    public List<order> findOrder(Integer h_id);

    @Select("select * from \"order\" where id=#{id}")
    public List<order> findOrderId(Integer id);

    @Select("select * from \"order\" where username = #{username}")
    public List<order> findOrderByName(String username);

    @Select("select * from \"order\" where h_id=#{h_id}")
    public order findOrderbyhid(Integer h_id);

    @Select("select * from \"order\" where username=#{username} and h_id=#{h_id}")
    public List<order> findOrderbyusername(String username,Integer h_id);

    @Update("UPDATE public.\"order\" SET \"HotelName\" = #{HotelName}, \"RoomNumber\" = #{RoomNumber},\"username\"= #{username},\"price\"=#{price} ,\n" +
            "room_type = #{room_type} , \"PhoneNumber\"=#{PhoneNumber},\"h_id\"=#{h_id},\"remark\"= #{remark} ,\"state\"= #{state} WHERE \"id\" = #{id}")
    public Integer updateOrder(order ord);

    @Insert("INSERT INTO public.\"order\" (id, \"HotelName\", \"RoomNumber\", username, price, \"BeginData\", \"EndData\", room_type, idcard, \"PhoneNumber\", h_id, remark, state) VALUES (DEFAULT, #{HotelName}, #{RoomNumber}, #{username}, #{price}, #{BeginData}, #{EndData}, #{room_type}, #{idcard}, #{PhoneNumber}, #{h_id}, #{remark}, #{state})")
    public Integer insertOrder(order ord);

    @Delete("DELETE FROM public.\"order\" WHERE id = #{id}")
    public Integer deleteOrderbyid(Integer id);

    @Select("select sum(price) as price, room_type from \"order\" where h_id=#{h_id} group by room_type")
    public List<RoomTypePrice> findRTP(Integer h_id);

    @Select("select sum(price) as price, to_char(\"BeginData\", 'yyyy-mm-dd') as date from \"order\" where h_id=#{h_id} group by to_char(\"BeginData\", 'yyyy-mm-dd') order by date asc")
    public List<RoomTypePrice> findDP(Integer h_id);

    @Select("select count(*) as number, to_char(\"BeginData\", 'yyyy-mm-dd') as date from \"order\" where h_id=#{h_id} group by to_char(\"BeginData\", 'yyyy-mm-dd') order by date asc")
    public List<RoomTypePrice> findDN(Integer h_id);

    @Select("select count(*) as number, room_type as date from \"order\" where h_id=5 group by room_type")
    public List<RoomTypePrice> findRTN(Integer h_id);


}
