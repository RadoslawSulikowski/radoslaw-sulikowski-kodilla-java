package com.kodilla.good.patterns.challenges.task3;


public class OrderRequestRetriever {
    private Product product;
    private int orderedQuantity;

    public OrderRequest retrieveEFS() {
        Producer producer = new ExtraFoodShop();
        //product = new InstanceClassOfProduct;
        //orderedQuantity = sampleQuantity;
        return new OrderRequest(producer, product, orderedQuantity, 6394);

    }
    public OrderRequest retrieveHS() {
        Producer producer = new HealthyShop();
        //product = new InstanceClassOfProduct;
        //orderedQuantity = sampleQuantity;
        return new OrderRequest(producer, product, orderedQuantity, 6394);

    }
    public OrderRequest retrieveGFS() {
        Producer producer = new GlutenFreeShop();
        //product = new InstanceClassOfProduct;
        //orderedQuantity = sampleQuantity;
        return new OrderRequest(producer, product, orderedQuantity, 6394);

    }
}
