package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
  @EqualsAndHashCode(callSuper = false)
    public class Hotel implements Serializable{

    public static final long serialVersionUID=1L;

    private Integer hotelID;

    private String hotelName;

    private String phone;

    private String email;

    private String address;


    }
