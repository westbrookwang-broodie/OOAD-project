package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@EqualsAndHashCode(callSuper = false)
public class evaluation implements Serializable{

    public static final long serialVersionUID=1L;

    private Integer id;

    private String username;

    private String url;

    private Integer overallRate;

    private String remark;

    private Integer enRate;

    private Integer noRate;

    private Integer serveRate;

    private Integer orderId;

}
