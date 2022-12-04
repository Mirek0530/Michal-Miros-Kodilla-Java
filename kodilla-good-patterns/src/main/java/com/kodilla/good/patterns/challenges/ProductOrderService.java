package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private ServiceDatabase serviceDatabase;
    private InformationService informationService;

    public ProductOrderService(final ServiceDatabase serviceDatabase, final InformationService informationService) {
        this.serviceDatabase = serviceDatabase;
        this.informationService = informationService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isAvailable = serviceDatabase.isProductAvailableInGivenQuantity(orderRequest.getProduct(), orderRequest.getQuantity());

        if (isAvailable) {
            informationService.inform(orderRequest.getUser());
            serviceDatabase.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity(), false);
        }
    }
}
