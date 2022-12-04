package com.kodilla.good.patterns.food2door;

public class FoodDeliveryService {

    public OrderDto proceedOrder(FoodProducer foodProducer, Product product, int quantity) {
        boolean succeedOrder = foodProducer.process(product, quantity);

        if (succeedOrder) {
            return new OrderDto(foodProducer, product, quantity, true);
        } else {
            return new OrderDto(foodProducer, product, quantity, false);
        }
    }
}
