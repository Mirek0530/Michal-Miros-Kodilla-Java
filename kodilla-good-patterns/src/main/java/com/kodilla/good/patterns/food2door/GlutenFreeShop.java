package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop extends FoodProducer {

    public GlutenFreeShop(String shopName) {
        super(shopName);
    }

    @Override
    boolean process(Product product, int quantity) {
        return (products.containsKey(product) && products.get(product) >= quantity);
    }
}
