package com.example.ooad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.ooad.mapper")
public class OoadApplication {

    public static void main(String[] args) {
        SpringApplication.run(OoadApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "ok";
    }


}


