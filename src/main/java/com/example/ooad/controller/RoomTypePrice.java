package com.example.ooad.controller;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoomTypePrice implements Serializable{

    public static final long serialVersionUID=1L;


    private String room_type;
    private Integer price;
    private String date;
    private Integer number;
}
