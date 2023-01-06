package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class Room implements Serializable {

    public static final long serialVersionUID=1L;

    private Integer id;

    private String HotelName;

    private String room_type;

    private Integer RoomNumber;

    private String graphPath;

    private Integer h_id;

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

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getGraphPath() {
        return graphPath;
    }

    public void setGraphPath(String graphPath) {
        this.graphPath = graphPath;
    }

    public Integer getH_id() {
        return h_id;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", HotelName='" + HotelName + '\'' +
                ", room_type='" + room_type + '\'' +
                ", RoomNumber=" + RoomNumber +
                ", graphPath='" + graphPath + '\'' +
                ", h_id=" + h_id +
                '}';
    }
}
