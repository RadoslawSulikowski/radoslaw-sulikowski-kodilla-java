package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsPizzaDecorator extends AbstractPizzaOrderDecorator {
    public MushroomsPizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(2));
    }

    @Override
    public String getOrder(){
        return super.getOrder() + " + Mushrooms";
    }
}

