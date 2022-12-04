package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop extends FoodProducer {

    public ExtraFoodShop(String shopName) {
        super(shopName);
    }

    @Override
    boolean process(Product product, int quantity) {
        boolean hasProcessSucceed = false;
        if (products.containsKey(product)) {
            hasProcessSucceed = products.get(product) >= quantity;
        }
        return hasProcessSucceed;
    }
}
