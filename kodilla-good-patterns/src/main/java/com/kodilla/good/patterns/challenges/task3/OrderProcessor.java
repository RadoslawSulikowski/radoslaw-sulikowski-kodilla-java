package com.kodilla.good.patterns.challenges.task3;


public class OrderProcessor {
    private OrderRequest orderRequest;

    public OrderProcessor(final OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderRequest.getProducer().process(this.orderRequest);

        if (isOrdered) {
            return new OrderDto(orderRequest, true);
        } else {
            return new OrderDto(orderRequest, false);
        }
    }

}
