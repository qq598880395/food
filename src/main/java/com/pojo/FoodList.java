package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("food_list")
public class FoodList implements Serializable {
    private int food_id;
    private int hotel_id;
    private double food_price;
    private String food_name;
    private String food_pic;
    private String food_type;
    private String food_details;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public double getFood_price() {
        return food_price;
    }

    public void setFood_price(double food_price) {
        this.food_price = food_price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_pic() {
        return food_pic;
    }

    public void setFood_pic(String food_pic) {
        this.food_pic = food_pic;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_details() {
        return food_details;
    }

    public void setFood_details(String food_details) {
        this.food_details = food_details;
    }
}
