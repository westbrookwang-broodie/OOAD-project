package com.example.ooad.controller;

import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.Room;
import com.example.ooad.enity.RoomType;
import com.example.ooad.enity.order;
import com.example.ooad.mapper.HotelMapper;
import com.example.ooad.mapper.RoomMapper;
import com.example.ooad.mapper.OrderMapper;
import com.example.ooad.mapper.RoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomTypeController {

    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @RequestMapping("/findallroomtype")
    public List find(){
        List<RoomType> list = roomTypeMapper.findAllRoomType();
        System.out.println(list);
        return list;
    }
    @RequestMapping("/findallroomtypebyR")
    public List findR(String room_type){
        List<RoomType> list = roomTypeMapper.findAllRoomTypes(room_type);
        System.out.println(list);
        return list;
    }

//    @RequestMapping("/findRooms")
//    public List<Room> findRooms(Integer h_id){
//        List<Room> list = roomMapper.findRooms(h_id);
//        System.out.println(list);
//        return list;
//    }

//    @RequestMapping("/findCurrentRooms")
//    public List<Room> findCurrentRooms(Integer h_id){
//        List<Room> list = roomMapper.findCurrentRooms(h_id);
//        System.out.println(list);
//        return list;
//    }

    @PostMapping("/insertRoomType")
    public String insertRoom(RoomType roomType){
        List<RoomType> list =roomTypeMapper.findsome(roomType.getRoom_type());
        int i=0;
        if(list.size()==0){
        i = roomTypeMapper.insert(roomType);}
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @PostMapping("/deleteRoomType")
    public String delete(Integer id){
        System.out.println(id);
        int i = roomTypeMapper.delete(id);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }
//
    @PostMapping("/updateRoomType")
    public String update(RoomType roomType){
        int   i =  roomTypeMapper.update(roomType);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }
}
