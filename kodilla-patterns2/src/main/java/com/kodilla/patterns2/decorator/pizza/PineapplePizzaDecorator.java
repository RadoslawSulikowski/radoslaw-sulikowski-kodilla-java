package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PineapplePizzaDecorator extends AbstractPizzaOrderDecorator {
    public PineapplePizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(3));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + " + Pineapple";
    }
}
