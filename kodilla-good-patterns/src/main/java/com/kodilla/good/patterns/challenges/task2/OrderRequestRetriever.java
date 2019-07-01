package com.kodilla.good.patterns.challenges.task2;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "Doe");
        Product product = new Game();
        int orderedQuantity = 1;

        return new OrderRequest(user, product, orderedQuantity);

    }
}
