package com.example.ooad.controller;

import com.example.ooad.enity.Hotel;
import com.example.ooad.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelMapper hotelMapper;

    @PostMapping("/findallhotel")
    public List find(){
        List<Hotel> list = hotelMapper.findAllHotel();
        System.out.println(list);
        return list;
    }


    @PostMapping("/findHotels")
    public List<Hotel> findhotels(Integer grade, String city, String district){
        List<Hotel> list = hotelMapper.findHotels(grade, city, district);
        System.out.println(list);
        return list;
    }

    @PostMapping("/findLow")
    public Integer findLowestPrice(Integer h_id){
        Integer price = hotelMapper.findLow(h_id);
        return price;
    }


    @RequestMapping("/findHotelsByCity")
    public List<Hotel> findHotelsByCity(String city){
        List<Hotel> list = hotelMapper.findHotelsByCity(city);
        System.out.println(list);
        return list;
    }

    @RequestMapping("/findByPrice")
    public List<Hotel> findHotelsByCity(Integer grade, String city, String district, Integer low, Integer high){
        List<Hotel> list = hotelMapper.findByPrice(grade, city, district, low, high);
        System.out.println(list);
        return list;
    }
}
