package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class RedPepperPizzaDecorator extends AbstractPizzaOrderDecorator {
    public RedPepperPizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(3));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + " + Red pepper";
    }
}
