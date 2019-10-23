package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaWithExtraCheeseSalamiAndOnionGetValue(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        pizza = new OlivesPizzaDecorator(pizza);
        //When
        BigDecimal value = pizza.getValue();
        //Then
        Assert.assertEquals(new BigDecimal(27), value);
    }

    @Test
    public void testPizzaWithExtraCheeseSalamiAndOnionGetOrder(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        pizza = new OlivesPizzaDecorator(pizza);
        //When
        String order = pizza.getOrder();
        //Then
        Assert.assertEquals("Dough with tomato sauce and cheese + Extra cheese + Salami + Olives", order);
    }

    @Test
    public void testPizzaWithTunaOnionOlivesAndPineappleGetValue(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new TunaPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new OlivesPizzaDecorator(pizza);
        pizza = new PineapplePizzaDecorator(pizza);
        //When
        BigDecimal value = pizza.getValue();
        //Then
        Assert.assertEquals(new BigDecimal(27), value);
    }

    @Test
    public void testPizzaWithTunaOnionOlivesAndPineappleGetOrder(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new TunaPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new OlivesPizzaDecorator(pizza);
        pizza = new PineapplePizzaDecorator(pizza);
        //When
        String order = pizza.getOrder();
        //Then
        Assert.assertEquals("Dough with tomato sauce and cheese + Tuna + Onion + Olives + Pineapple", order);
    }

    @Test
    public void testPizzaWithHamMushroomsPineappleAndExtraCheeseGetValue(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new MushroomsPizzaDecorator(pizza);
        pizza = new PineapplePizzaDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //When
        BigDecimal value = pizza.getValue();
        //Then
        Assert.assertEquals(new BigDecimal(29), value);
    }

    @Test
    public void testPizzaWithHamMushroomsPineappleAndExtraCheeseGetOrder(){
        //Given
        PizzaOrder pizza = new BasicPizzaMargaritaOrder();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new MushroomsPizzaDecorator(pizza);
        pizza = new PineapplePizzaDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //When
        String order = pizza.getOrder();
        //Then
        Assert.assertEquals("Dough with tomato sauce and cheese + Ham + Mushrooms + Pineapple + Extra cheese", order);
    }

}
