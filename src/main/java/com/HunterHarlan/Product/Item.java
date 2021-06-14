package com.HunterHarlan.Product;

/**
    Interface for inventory items. Should be implemented by Product class and is used to define the features of Product
    class.
    @author Hunter Shaw
    @version 0.1
 */
public interface Item {
    /**
     *
     * @return The Products name.
     */
    public String getName();

    /**
     *
     * @return The Products serial number.
     */
    public String getSerialNum();

    /**
     *
     * @return the quantity of the Product.
     */
    public int getQuantity();


}
