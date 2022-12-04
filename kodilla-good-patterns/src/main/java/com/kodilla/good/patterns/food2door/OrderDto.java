package com.kodilla.good.patterns.food2door;

public class OrderDto {
    private final FoodProducer foodProducer;
    private final Product product;
    private final int quantity;
    private final boolean isAvailable;

    public OrderDto(FoodProducer foodProducer, Product product, int quantity, boolean isAvailable) {
        this.foodProducer = foodProducer;
        this.product = product;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Order: " + quantity + " " + product + " at: " + foodProducer.getShopName() + ". Is available: " + isAvailable;
    }
}
