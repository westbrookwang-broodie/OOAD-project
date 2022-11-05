package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
  @EqualsAndHashCode(callSuper = false)
    public class RoomType implements Serializable{

    private static final long serialVersionUID=1L;

    private Integer typeId;

    private String roomType;

    private String remark;

    private Double price;

    private BigDecimal discount;

    private Integer bedNum;

    private Integer bedSize;
}
