package com.kodilla.good.patterns.challenges.task2;

public class Game implements Product {

    private static int quantity = 10;

    @Override
    public boolean isAvailable(int orderedQuantity) {
        return ((quantity - orderedQuantity) >= 0);
    }

    @Override
    public void reduceQuantity(int orderedQuantity) {
        quantity -= orderedQuantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

}
