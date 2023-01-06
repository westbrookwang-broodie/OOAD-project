package com.example.ooad.controller;

import com.example.ooad.enity.User;
import com.example.ooad.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/find")
    public List find(){
        List<User> list = userMapper.find();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/login")
    public Boolean login(String username, String password){
        List<User> list = userMapper.login(username,password);
        if (list.size() == 1){
            return true;
        }
        else{
            return false;
        }

    }

    @PostMapping("/register")
    public String register(User user){
        int i = userMapper.insert(user);
        if (i > 0 ){
            return "成功";
        }
        else{
            return  "失败";
        }
    }
}
