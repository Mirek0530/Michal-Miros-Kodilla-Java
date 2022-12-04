package com.kodilla.good.patterns.challenges;

public interface ServiceDatabase {

    boolean isProductAvailableInGivenQuantity(Product product, int quantity);
    void createOrder(User user, Product product, int quantity);
}
