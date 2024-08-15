package com.example.hw_43m.rv_detail;

import java.io.Serializable;

public class DetailModel implements Serializable {

    private String name;
    private String image;
    private String price;
    private String desc;

    public DetailModel(String name, String image, String price, String desc) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
