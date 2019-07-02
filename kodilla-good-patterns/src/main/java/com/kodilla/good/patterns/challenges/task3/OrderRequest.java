package com.kodilla.good.patterns.challenges.task3;


public class OrderRequest {
    private Producer producer;
    private Product product;
    private int orderedQuantity;
    private final int ORDER_NUMBER;

    public OrderRequest(Producer producer, Product product, int orderedQuantity, final int orderNumber) {
        this.producer = producer;
        this.product = product;
        this.orderedQuantity = orderedQuantity;
        this.ORDER_NUMBER = orderNumber;

    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public int getORDER_NUMBER() {
        return ORDER_NUMBER;
    }
}
