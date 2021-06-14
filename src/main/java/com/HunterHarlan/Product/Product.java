package com.HunterHarlan.Product;

import java.io.Serializable;

/**
 * Class which will define a item in the system as a product.
 * @author Hunter Shaw
 * @version 0.1
 */
public class Product implements Serializable, Item {
    private String name;
    private String serialNum;
    private int quantity;

    public Product(String name, String serialNum, int quantity) {
        this.name = name;
        this.serialNum = serialNum;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSerialNum() {
        return serialNum;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
