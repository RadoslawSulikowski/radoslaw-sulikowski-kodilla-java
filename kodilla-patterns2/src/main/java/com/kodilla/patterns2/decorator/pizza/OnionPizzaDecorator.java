package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionPizzaDecorator extends AbstractPizzaOrderDecorator {
    public OnionPizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(2));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + " + Onion";
    }
}
