package com.example.ooad.enity;

public class RoomType {

    private Integer id;

    private String room_type;

    private Float area;

    private Integer bed_number;

    private Float price;

    private Float discount;

    private Integer kind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Integer getBed_number() {
        return bed_number;
    }

    public void setBed_number(Integer bed_number) {
        this.bed_number = bed_number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", room_type='" + room_type + '\'' +
                ", area=" + area +
                ", bed_number=" + bed_number +
                ", price=" + price +
                ", discount=" + discount +
                ", kind=" + kind +
                '}';
    }
}
