package com.kodilla.patterns.factory;

public class Circle implements Shape {
    final String name;
    final double radius;

    public Circle(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getCircumference() {
        return Math.PI * radius * 2;
    }
}
