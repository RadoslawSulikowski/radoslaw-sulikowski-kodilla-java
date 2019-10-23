package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TunaPizzaDecorator extends AbstractPizzaOrderDecorator {
    public TunaPizzaDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getValue() {
        return super.getValue().add(new BigDecimal(4));
    }

    @Override
    public String getOrder(){
        return super.getOrder() + " + Tuna";
    }
}
