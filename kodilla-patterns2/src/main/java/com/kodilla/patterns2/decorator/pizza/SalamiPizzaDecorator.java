package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiPizzaDecorator extends AbstractPizzaOrderDecorator {
    public SalamiPizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(4));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + " + Salami";
    }
}
