package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class Database implements ServiceDatabase {
    private Map<Product, Integer> products;

    public Database() {
        products = new HashMap<>();
    }

    @Override
    public boolean isAvailable(Product product, int quantity) {
        boolean available = false;
        if (products.containsKey(product)) {
            available = products.get(product) >= quantity;
        }
        return available;
    }

    @Override
    public void createOrder(User user, Product product, int quantity) {
        products.put(product, products.get(product) - quantity);
        System.out.println("Order created for user: " + user.getUserName());
    }

    public void addItem(Product product, int quantity) {
        products.put(product, quantity);
    }
}
