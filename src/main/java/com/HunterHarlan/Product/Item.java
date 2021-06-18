package com.HunterHarlan.Product;

/**
    Interface for inventory items. Should be implemented by Product class and is used to define the features of Product
    class.
    @author Hunter Shaw
    @version 0.1
 */
public interface Item {

    /**
     * Returns the name of the product that invokes the method.
     * @return The Products name.
     */
    String getName();

    /**
     * Returns the serial number of the product that invokes the method.
     * @return The Products serial number.
     */
    String getSerialNum();

    /**
     * Returns the quantity of the product that invokes the method.
     * @return the quantity of the Product.
     */
    int getQuantity();

    /**
     * Sets the name of the product that invokes the method to the String value of the parameter.
     * @param name
     */
    void setName(String name);

    /**
     * Sets the serial number of the product that invokes the method to the value of the parameter.
     * @param serialNum
     */
    void setSerialNum(String serialNum);

    /**
     * Sets the quantity of the product that invokes the method to the value of the parameter.
     * @param quantity
     */
    void setQuantity(int quantity);


}
