package com.kodilla.patterns.factory;

public class Rectangle implements Shape{
    final String name;
    final double length;
    final double width;

    public Rectangle(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * length;
    }
}
