package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
  @EqualsAndHashCode(callSuper = false)
    public class Room implements Serializable {

    public static final long serialVersionUID=1L;

    private Integer roomId;

    private Integer roomNum;

    private Integer roomType;

    private Double roomPrice;

    private BigDecimal roomDiscount;

    private Integer roomStatus;

    private String remark;

    }
