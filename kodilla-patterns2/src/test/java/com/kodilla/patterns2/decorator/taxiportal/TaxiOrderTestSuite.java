package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        //When
        BigDecimal cost = order.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(5.00), cost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        //When
        String description = order.getDescription();
        //Then
        Assert.assertEquals("Drive a course", description);
    }

    @Test
    public void testNetworkTaxiOrderGetCost(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(40.00), cost);
    }

    @Test
    public void testNetworkOrderGetDescription(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(37), cost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        Assert.assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatGetCost(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(29), cost);
    }

    @Test
    public void testUberWithTwoChildSeatGetDescription(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ExpressDecorator(order);
        order = new VariantVipDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(57), cost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription(){
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ExpressDecorator(order);
        order = new VariantVipDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Taxi Network + child seat express service variant VIP", description);
    }

}
