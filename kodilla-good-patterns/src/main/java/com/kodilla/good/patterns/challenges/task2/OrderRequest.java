package com.kodilla.good.patterns.challenges.task2;

public class OrderRequest {
    private User user;
    private Product product;
    private int orderedQuantity;

    public OrderRequest(User user, Product product, int orderedQuantity) {
        this.user = user;
        this.product = product;
        this.orderedQuantity = orderedQuantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }


}
