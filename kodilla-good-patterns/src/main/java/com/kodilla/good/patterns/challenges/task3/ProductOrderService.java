package com.kodilla.good.patterns.challenges.task3;

public class ProductOrderService {

    public static void main(String[] args){
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();

        System.out.println("\nEXTRA FOOD SHOP ORDER");

        OrderRequest dataFromPreviousSubsystem = orderRequestRetriever.retrieveEFS();
        OrderProcessor orderProcessor = new OrderProcessor(dataFromPreviousSubsystem);
        OrderDto dataToAnotherSubsystem = orderProcessor.process(dataFromPreviousSubsystem);

        System.out.println("\nGLUTEN FREE SHOP ORDER");
        dataFromPreviousSubsystem = orderRequestRetriever.retrieveGFS();
        orderProcessor = new OrderProcessor(dataFromPreviousSubsystem);
        dataToAnotherSubsystem = orderProcessor.process(orderRequestRetriever.retrieveEFS());

        System.out.println("\nHEALTHY SHOP ORDER");
        dataFromPreviousSubsystem = orderRequestRetriever.retrieveHS();
        orderProcessor = new OrderProcessor(dataFromPreviousSubsystem);
        dataToAnotherSubsystem = orderProcessor.process(dataFromPreviousSubsystem);

    }
}
