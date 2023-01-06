package com.example.ooad.controller;

import com.example.ooad.enity.User;
import com.example.ooad.enity.evaluation;
import com.example.ooad.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/userUpdate")
    //@RequestParam的参数值为前端FormData对象的存储内容的key值
    //多文件上传时，用MultipartFile[]数组进行接收，单文件也可以这样接收
    public int userUpdate(@RequestParam("upFile") MultipartFile[] files, HttpServletRequest req, @RequestParam("upData") String[] review) {
        System.out.println("接收到的文件有"+files.length+"个");
        for(MultipartFile f:files){
            System.out.println("正在存储"+f.getOriginalFilename()+"文件");
            String path = "C:\\Users\\86177\\Desktop\\files\\user";
            String name=f.getOriginalFilename();
            File floder=new File(path);
            if(!floder.isDirectory())
                floder.mkdirs();
            try{
                f.transferTo(new File(floder,name));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String username = review[0];
            Integer age = Integer.parseInt(review[1]);
            Integer gender = Integer.parseInt(review[2]);
            String email = review[3];
            String address = review[4];
            String remark = review[5];
            String phone = review[6];
            String url = path +"\\"+name;

            int u = userMapper.updateUser(gender,phone,email,address,"白金会员",age,remark,url,username);
            if(u!=0){
                System.out.println("成功");
            }


//            evaluation.setUrl(path+name);

//            evaluation.setUrl(path+ "\\" +review[0]);
//            int e = userMapper.updateUser();
//            if(e!=0){
//                System.out.println("插入成功");
//            }

        }
        return 200;
    }

    @PostMapping("/userUpdate1")
    public int userUpdate1(@RequestParam("upData") String[] review){
        String username = review[0];
        Integer age = Integer.parseInt(review[1]);
        Integer gender = Integer.parseInt(review[2]);
        String email = review[3];
        String address = review[4];
        String remark = review[5];
        String phone = review[6];
        int i = userMapper.updateUser1(gender,phone,email,address,"白金会员",age,remark,username);
        if(i!=0){
            System.out.println("成功");
            return 200;
        }
        return 300;
    }

    @RequestMapping(value = "/getUser")
    public void GetUser(HttpServletRequest request, HttpServletResponse response, String username) throws IOException {
        List<User> user = userMapper.get(username);
        User user1 = user.get(0);
        String path = user1.getUrl();

        File file = new File(path);
        FileInputStream fis;
        fis = new FileInputStream(file);

        long size = file.length();
        byte[] data = new byte[(int) size];
        fis.read(data, 0, (int)size);
        fis.close();
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/getUserInfo")
    public List<User> getUserInfo(String username) {
        List<User> user = userMapper.get(username);
        return user;
    }

    @RequestMapping("/password")
    public int updatePassword(String username, String password){
        int i = userMapper.updatePassword(username, password);
        if (i!=0) {
            return 200;
        }
        else {
            return 300;
        }
    }

    @RequestMapping("/points")
    public int updatePoints(String username, Integer points){
        int i = userMapper.updatePoints(username, points);
        if (i!=0) {
            return 200;
        }
        else {
            return 300;
        }
    }

    @RequestMapping("/points1")
    public int updatePoints1(String username, Integer points){
        int i = userMapper.updatePoints1(username, points);
        if (i!=0) {
            return 200;
        }
        else {
            return 300;
        }
    }

    @RequestMapping("/isAdmin")
    public Integer isAdmin(String username) {
        List<User> user = userMapper.get(username);
        User user1 = user.get(0);
        if (user1.getGrant().equals("管理员")){
            return 1;
        }
        else {
            return 0;
        }
    }



}
