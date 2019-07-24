package com.pojo;

import java.io.Serializable;

public class VipList implements Serializable {
    private int vip_id;
    private String vip_tel;
    private String vip_name;
    private String vip_IDcard;
    private int hotel_id;
    private int vip_money;

    public int getVip_id() {
        return vip_id;
    }

    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public String getVip_tel() {
        return vip_tel;
    }

    public void setVip_tel(String vip_tel) {
        this.vip_tel = vip_tel;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public String getVip_IDcard() {
        return vip_IDcard;
    }

    public void setVip_IDcard(String vip_IDcard) {
        this.vip_IDcard = vip_IDcard;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getVip_money() {
        return vip_money;
    }

    public void setVip_money(int vip_money) {
        this.vip_money = vip_money;
    }
}
