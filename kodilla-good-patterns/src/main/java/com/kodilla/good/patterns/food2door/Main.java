package com.kodilla.good.patterns.food2door;

public class Main {
    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop("Extra Food Shop");
        HealthyShop healthyShop = new HealthyShop("Healthy Shop");
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop("Gluten Free Shop");

        Product bananas = new Product("Bananas", 6.99);
        Product apples = new Product("Apples", 2.99);
        Product avocado = new Product("Avocado", 9.99);
        Product gojiberries = new Product("Goji berries", 14.99);
        Product corn = new Product("Corn", 4.99);
        Product rice = new Product("Rice", 1.99);
        Product carrots = new Product("Carrots", 3.50);

        glutenFreeShop.addItem(corn, 530);
        glutenFreeShop.addItem(rice, 1400);

        healthyShop.addItem(bananas, 320);
        healthyShop.addItem(apples, 965);
        healthyShop.addItem(carrots, 512);

        extraFoodShop.addItem(avocado, 210);
        extraFoodShop.addItem(gojiberries, 140);

        FoodDeliveryService foodDeliveryService = new FoodDeliveryService();
        OrderDto orderDto;

        orderDto = foodDeliveryService.proceedOrder(glutenFreeShop, rice, 5);
        System.out.println(orderDto);

        orderDto = foodDeliveryService.proceedOrder(healthyShop, carrots, 20);
        System.out.println(orderDto);

        orderDto = foodDeliveryService.proceedOrder(extraFoodShop, apples, 50);
        System.out.println(orderDto);

    }
}
