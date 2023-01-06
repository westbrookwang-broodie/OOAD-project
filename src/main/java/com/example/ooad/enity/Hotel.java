package com.example.ooad.enity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Hotel implements Serializable{

    public static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private Integer grade;

    private String location;

    private String city;

    private String district;

    private String remark;

    private String graphPath;

    private String lngLat;

    private Integer price;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGraphPath() {
        return graphPath;
    }

    public void setGraphPath(String graphPath) {
        this.graphPath = graphPath;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", remark='" + remark + '\'' +
                ", graphPath='" + graphPath + '\'' +
                '}';
    }
}
