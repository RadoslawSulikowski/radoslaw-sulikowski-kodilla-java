package com.kodilla.good.patterns.challenges.task2;

public interface Product {

    void reduceQuantity(int orderedQuantity);

    boolean isAvailable(int orderedQuantity);

    int getQuantity();

}
