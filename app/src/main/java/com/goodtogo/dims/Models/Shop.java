package com.goodtogo.dims.Models;

public class Shop {
    public  String name, url;
    Integer imgId;

    public Shop() {
    }

    public Shop(String name, String url, Integer ingId) {
        this.name = name;
        this.url = url;
        this.imgId = ingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }
}
