package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaMargaritaOrder implements PizzaOrder {

    @Override
    public BigDecimal getValue(){
        return new BigDecimal(15);
    }

    @Override
    public String getOrder() {
        return "Dough with tomato sauce and cheese";
    }

}
