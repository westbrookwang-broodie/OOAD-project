package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;

@Data
  @EqualsAndHashCode(callSuper = false)
    public class User implements Serializable{

    private static final long serialVersionUID=1L;

    private Integer idcard;

    private String username;

    private String password;

    private String name;

    private Integer gender;

    private String phone;

    private String email;

    private String address;

    private Integer grant;

}
