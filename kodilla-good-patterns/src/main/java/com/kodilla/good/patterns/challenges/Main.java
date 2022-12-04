package com.kodilla.good.patterns.challenges;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MailSender mailSender = new MailSender();

        Product chess = new Product("Chess", 19.99, "Play chess with your friends!");
        Product sneakers = new Product("Sneakers", 59.99, "Brand new sneakers from summer collection!");
        Product toothbrush = new Product("Toothbrush", 6.99, "White teeth and fresh breath");

        database.addItem(chess, 10);
        database.addItem(sneakers, 56);
        database.addItem(toothbrush, 239);

        User matty67 = new User(56781, "matty67", "matty@yahoo.com");
        User rosie_0 = new User(90128, "rosie_0", "rosie_0@gmail.com");

        ProductOrderService productOrderService = new ProductOrderService(database, mailSender);
        OrderDto orderDto;

        OrderRequest firstOrder = new OrderRequest(matty67, chess, 10);
        OrderRequest secondOrder = new OrderRequest(rosie_0, toothbrush, 2);
        OrderRequest thirdOrder = new OrderRequest(rosie_0, chess, 1);

        orderDto = productOrderService.process(firstOrder);
        System.out.println(orderDto.toString());

        orderDto = productOrderService.process(secondOrder);
        System.out.println(orderDto.toString());

        orderDto = productOrderService.process(thirdOrder);
        System.out.println(orderDto.toString());
    }
}
