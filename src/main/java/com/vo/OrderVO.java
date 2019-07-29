package com.vo;

import java.util.Date;

public class OrderVO {
    private  String food_order_id;
    private int hotel_id;
    private int vip_id;
    private int food_id;
    private double cost;
    private String order_time;

    public String getFood_order_id() {
        return food_order_id;
    }

    public void setFood_order_id(String food_order_id) {
        this.food_order_id = food_order_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getVip_id() {
        return vip_id;
    }

    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
}
