package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public abstract class FoodProducer {

    protected Map<Product, Integer> products;
    protected String shopName;

    public FoodProducer(String shopName) {
        this.shopName = shopName;
        this.products = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        products.put(product, quantity);
    }

    public String getShopName() {
        return shopName;
    }

    abstract boolean process(Product product, int quantity);
}
