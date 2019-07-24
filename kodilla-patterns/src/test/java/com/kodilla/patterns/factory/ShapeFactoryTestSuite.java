package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void testFactoryCircle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        Assert.assertEquals("Circle", circle.getName());
        Assert.assertEquals(Math.PI*4.50*4.50, circle.getArea(), 0);
        Assert.assertEquals(Math.PI*4.50*2, circle.getCircumference(), 0);
    }

    @Test
    public void testFactorySquare() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        Assert.assertEquals("Square", square.getName());
        Assert.assertEquals(49.0, square.getArea(), 0);
        Assert.assertEquals(28.0, square.getCircumference(), 0);
    }

    @Test
    public void testFactoryRectangle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        Assert.assertEquals("Rectangle", rectangle.getName());
        Assert.assertEquals(37.5, rectangle.getArea(), 0);
        Assert.assertEquals(35.0, rectangle.getCircumference(), 0);
    }
}
