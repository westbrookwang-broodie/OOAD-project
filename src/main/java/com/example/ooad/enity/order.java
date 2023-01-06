package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@EqualsAndHashCode(callSuper = false)
public class order implements Serializable {

    public static final long serialVersionUID=1L;

    private Integer id;

    private String HotelName;

    private Integer RoomNumber;

    private String username;

    private Integer price;

    private Timestamp BeginData;

    private Timestamp EndData;

    private Integer h_id;

    private String room_type;

    private Integer idcard;

    private String PhoneNumber;

    private String remark;

    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getBeginData() {
        return BeginData;
    }

    public void setBeginData(Timestamp beginData) {
        BeginData = beginData;
    }

    public Timestamp getEndData() {
        return EndData;
    }

    public void setEndData(Timestamp endData) {
        EndData = endData;
    }

    public Integer getH_id() {
        return h_id;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", HotelName='" + HotelName + '\'' +
                ", RoomNumber=" + RoomNumber +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", BeginData=" + BeginData +
                ", EndData=" + EndData +
                ", h_id=" + h_id +
                ", room_type='" + room_type + '\'' +
                ", idcard=" + idcard +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                '}';
    }
}
