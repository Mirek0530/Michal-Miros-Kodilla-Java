package com.kodilla.good.patterns.food2door;

public class HealthyShop extends FoodProducer {

    public HealthyShop(String shopName) {
        super(shopName);
    }

    @Override
    boolean process(Product product, int quantity) {
        boolean isOrderPossibleToProcess = false;
        if (product != null && quantity > 0) {
            isOrderPossibleToProcess = products.containsKey(product) && products.get(product) >= quantity;
        }
        return isOrderPossibleToProcess;
    }
}
