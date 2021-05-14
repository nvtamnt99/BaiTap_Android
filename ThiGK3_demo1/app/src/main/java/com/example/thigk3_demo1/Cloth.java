package com.example.thigk3_demo1;

import java.io.Serializable;

public class Cloth implements Serializable {
    private int imgCloth, price;
    private String name;

    public Cloth(int imgCloth, int price, String name) {
        this.imgCloth = imgCloth;
        this.price = price;
        this.name = name;
    }

    public int getImgCloth() {
        return imgCloth;
    }

    public void setImgCloth(int imgCloth) {
        this.imgCloth = imgCloth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
