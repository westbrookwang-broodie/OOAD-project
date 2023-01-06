package com.example.ooad.controller;
import cn.hutool.db.sql.Order;
import com.example.ooad.enity.order;
import com.example.ooad.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/findallorder")
    public List find(){
        List<order> list = orderMapper.findAllOrder();
        System.out.println(list);
        return list;
    }


    @RequestMapping("/findOrderByName")
    public List find1(String username){
        List<order> list = orderMapper.findOrderByName(username);
        System.out.println(list);
        return list;
    }


    @RequestMapping("/findOrders")
    public List<order> findorder(Integer h_id){
        List<order> order = orderMapper.findOrder(h_id);
        System.out.println(order);
        return order;
    }

    @RequestMapping("/insertOrder")
    public String insertorder(order or){
        int  i = orderMapper.insertOrder(or);
        if (i>0){
            return "成功插入订单";
        }else {
            return "新增订单失败";
        }
    }

    @RequestMapping("/deleteOrder")
    public String deletetorder(Integer id){
        int  i = orderMapper.deleteOrderbyid(id);
        if (i>0){
            return "成功删除订单";
        }else {
            return "删除订单失败";
        }
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(order or){
        int  i = orderMapper.updateOrder(or);
        System.out.print(or);
        if (i>0){
            return "成功更新订单";
        }else {
            return "更新订单失败";
        }
    }

    @RequestMapping("/findO")
    public List<order> findOrder(String username,Integer h_id){
        List<order> order = orderMapper.findOrderbyusername(username,h_id);
        System.out.println(order);
        return order;
    }

    @RequestMapping("/insertO")
    public Integer insertorder1(String HotelName, Integer RoomNumber, String username, Integer price, String BeginData, String EndData, String room_type, String PhoneNumber, Integer h_id){
        order order = new order();
        order.setHotelName(HotelName);
        order.setRoomNumber(RoomNumber);
        order.setUsername(username);
        order.setPrice(price);
        order.setBeginData(Timestamp.valueOf(BeginData));
        order.setEndData(Timestamp.valueOf(EndData));
        order.setRoom_type(room_type);
        order.setPhoneNumber(PhoneNumber);
        order.setH_id(h_id);
        order.setState(0);
        int  i = orderMapper.insertOrder(order);
        List<order> now= orderMapper.findAllOrder();
        if (i>0){
            return now.get(now.size()-1).getId();
        }else {
            return 300;
        }
    }

    @RequestMapping("/priceByRoomType")
    public List<RoomTypePrice> findRT(Integer h_id){
        return orderMapper.findRTP(h_id);
    }

    @RequestMapping("/priceByDate")
    public List<RoomTypePrice> findDP(Integer h_id){
        return orderMapper.findDP(h_id);
    }

    @RequestMapping("/numberByDate")
    public List<RoomTypePrice> findDN(Integer h_id){
        return orderMapper.findDN(h_id);
    }

    @RequestMapping("/numberByRoomType")
    public List<RoomTypePrice> findRTN(Integer h_id){
        return orderMapper.findRTN(h_id);
    }


}
