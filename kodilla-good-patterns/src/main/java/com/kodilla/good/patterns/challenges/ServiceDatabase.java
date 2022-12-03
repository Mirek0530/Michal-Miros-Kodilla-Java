package com.kodilla.good.patterns.challenges;

public interface ServiceDatabase {

    boolean isAvailable(Product product, int quantity);
    void createOrder(User user, Product product, int quantity);
}
