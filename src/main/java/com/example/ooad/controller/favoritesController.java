package com.example.ooad.controller;
import com.example.ooad.enity.favorites;
import com.example.ooad.enity.Hotel;
import com.example.ooad.mapper.favoritesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class favoritesController {

    @Autowired
    private favoritesMapper favoritesMapper;

    @RequestMapping("/insertFav")
    public int insert(String username, Integer h_id){
        int i = favoritesMapper.insert(username,h_id);
        if(i > 0) {
            return 200;
        }
        else {
            return 300;
        }
    }
    @RequestMapping("/getFav")
    public List<Hotel> get(String username){
        List<Hotel> hotels = favoritesMapper.hotels(username);
        return hotels;
    }
    @RequestMapping("/deleteFav")
    public Integer delete(String username, Integer h_id){
        int i = favoritesMapper.delete(username, h_id);
        if (i>0){
            return 200;
        }
        else {
            return 300;
        }
    }

    @RequestMapping("/isFav")
    public int get1(String username, Integer h_id){
        List<favorites> hotels = favoritesMapper.favs(username, h_id);
        if(hotels.size()==0){
            return 0;
        }
        else {
            return 1;
        }
    }

}
