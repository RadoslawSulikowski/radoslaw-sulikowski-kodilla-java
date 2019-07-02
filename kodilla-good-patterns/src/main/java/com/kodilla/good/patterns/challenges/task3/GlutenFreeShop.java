package com.kodilla.good.patterns.challenges.task3;

public class GlutenFreeShop implements Producer {

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (!this.equals(orderRequest.getProducer())) {
            System.out.println("Order applies to another store");
            return false;
        }
        Producer.superProcess();
        System.out.println("GlutenFreeShop implementation of 'process' method.");
        return true;
    }
}
