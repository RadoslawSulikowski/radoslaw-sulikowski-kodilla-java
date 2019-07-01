package com.kodilla.good.patterns.challenges.task2;

public class GameOrderRepository implements OrderRepository {

    @Override
    public boolean createOrder(User user, Product product, int orderedQuantity) {
        System.out.println("Order stored in Game Order Repository");
        return true;
    }
}
