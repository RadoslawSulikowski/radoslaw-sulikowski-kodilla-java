package com.kodilla.good.patterns.challenges.task3;

public interface Producer {

    static void superProcess(){
        System.out.println("Common implementation of the 'process' method for all inheriting classes");
    }
    boolean process(OrderRequest orderRequest);
}
