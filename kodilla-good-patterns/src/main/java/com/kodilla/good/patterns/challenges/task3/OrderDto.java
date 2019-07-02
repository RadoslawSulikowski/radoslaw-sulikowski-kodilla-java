package com.kodilla.good.patterns.challenges.task3;


public class OrderDto {

    private OrderRequest orderRequest;
    private boolean isOrdered;

    public OrderDto(OrderRequest orderRequest, boolean orderAccepted) {
        this.orderRequest = orderRequest;
        this.isOrdered = orderAccepted;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrderAccepted() {
        return isOrdered;
    }

}

