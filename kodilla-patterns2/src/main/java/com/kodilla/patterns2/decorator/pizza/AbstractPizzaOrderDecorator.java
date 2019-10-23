package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder){
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getValue(){
        return pizzaOrder.getValue();
    }

    @Override
    public String getOrder(){
        return pizzaOrder.getOrder();
    }
}
