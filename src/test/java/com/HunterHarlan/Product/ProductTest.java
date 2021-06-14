package com.HunterHarlan.Product;


import org.junit.jupiter.api.Test;

class ProductTest {

    private Product case1 = new Product("Toilet Paper", "fn46b", 12);

    @Test
    void testName() {
        assert case1.getName().equals("Toilet Paper");
    }

    @Test
    void getSerialNum() {
    }

    @Test
    void getQuantity() {
    }
}