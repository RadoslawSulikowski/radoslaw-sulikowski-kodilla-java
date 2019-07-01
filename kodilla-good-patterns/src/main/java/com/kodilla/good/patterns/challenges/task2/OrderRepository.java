package com.kodilla.good.patterns.challenges.task2;

public interface OrderRepository {
    boolean createOrder(User user, Product product, int orderedQuantity);
}
