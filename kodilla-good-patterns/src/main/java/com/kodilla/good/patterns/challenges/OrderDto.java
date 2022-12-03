package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User user;
    private Product product;
    private int quantity;
    private boolean isAvailable;

    public OrderDto(User user, Product product, int quantity, boolean isAvailable) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
