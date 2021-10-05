package com.rashik.fruitdeliveryv2.model;

import java.util.List;

public class DataController {

    public static DataController instance;

    public static DataController getInstance()
    {
        if (instance==null)
        {
            instance=new DataController();
        }
        return instance;
    }

    FruitShopInterface fruitShopInterface;
    List<MenuItem> currentMenuItemList;

    public FruitShopInterface getFruitShopInterface() {
        return fruitShopInterface;
    }

    public void setFruitShopInterface(FruitShopInterface fruitShopInterface) {
        this.fruitShopInterface = fruitShopInterface;
    }

    public List<MenuItem> getCurrentMenuItemList() {
        return currentMenuItemList;
    }

    public void setCurrentMenuItemList(List<MenuItem> currentMenuItemList) {
        this.currentMenuItemList = currentMenuItemList;
    }
}
