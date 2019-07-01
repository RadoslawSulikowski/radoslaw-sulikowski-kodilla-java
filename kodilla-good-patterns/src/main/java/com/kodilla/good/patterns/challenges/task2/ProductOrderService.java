package com.kodilla.good.patterns.challenges.task2;

public class ProductOrderService {

    public static void main(String[] args){
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor productOrderService = new OrderProcessor(new SMSService(), new GameOrderService(), new GameOrderRepository());

        productOrderService.process(orderRequest);

    }
}
