package com.rashik.fruitdeliveryv2.model;

import java.util.List;

public class FruitShop {

    String fruitShopName;
    String fruitShopDescription;
    String fruitShopImageUrl;
    String fruitShopLocation;

    List<MenuItem> fruitShopMenuList;

    public FruitShop() {
    }

    public String getFruitShopName() {
        return fruitShopName;
    }

    public void setFruitShopName(String fruitShopName) {
        this.fruitShopName = fruitShopName;
    }

    public String getFruitShopDescription() {
        return fruitShopDescription;
    }

    public void setFruitShopDescription(String fruitShopDescription) {
        this.fruitShopDescription = fruitShopDescription;
    }

    public String getFruitShopImageUrl() {
        return fruitShopImageUrl;
    }

    public void setFruitShopImageUrl(String fruitShopImageUrl) {
        this.fruitShopImageUrl = fruitShopImageUrl;
    }

    public String getFruitShopLocation() {
        return fruitShopLocation;
    }

    public void setFruitShopLocation(String fruitShopLocation) {
        this.fruitShopLocation = fruitShopLocation;
    }

    public List<MenuItem> getFruitShopMenuList() {
        return fruitShopMenuList;
    }

    public void setFruitShopMenuList(List<MenuItem> fruitShopMenuList) {
        this.fruitShopMenuList = fruitShopMenuList;
    }
}
