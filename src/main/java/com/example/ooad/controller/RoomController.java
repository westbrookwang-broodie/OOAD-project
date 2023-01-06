package com.example.ooad.controller;

import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.Room;
import com.example.ooad.enity.order;
import com.example.ooad.mapper.HotelMapper;
import com.example.ooad.mapper.RoomMapper;
import com.example.ooad.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomMapper roomMapper;

    @RequestMapping("/findallroom")
    public List find(){
        List<Room> list = roomMapper.findAllRoom();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/findRooms")
    public List<Room> findRooms(Integer h_id){
        List<Room> list = roomMapper.findRooms(h_id);
        System.out.println(list);
        return list;
    }

    @RequestMapping("/findCurrentRooms")
    public List<Room> findCurrentRooms(Integer h_id){
        List<Room> list = roomMapper.findCurrentRooms(h_id);
        System.out.println(list);
        return list;
    }

    @PostMapping("/insertRoom")
    public String insertRoom(Room room){
        List<Room> list = roomMapper.findtheroom(room.getH_id(), room.getRoomNumber());
        int i =0 ;
        if(list.size() ==0){
        i = roomMapper.insert(room);}
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @PostMapping("/deleteRoom")
    public String delete(Integer id){
        int i = roomMapper.delete(id);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @PostMapping ("/updateRoom")
    public String update(Room room){
        List<Room> list = roomMapper.findtheroom(room.getH_id(), room.getRoomNumber());
        int i=0;
        if(list.size()==0) {
             i = roomMapper.update(room);
        }
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @PostMapping("/judge")
    public Integer judge(Integer h_id,Integer RoomNumber){
        List<Room> list = roomMapper.findtheroom(h_id, RoomNumber);
        return  list.size();
    }
}
