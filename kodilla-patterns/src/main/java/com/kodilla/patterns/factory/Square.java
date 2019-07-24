package com.kodilla.patterns.factory;

public class Square implements Shape {
    final String name;
    final double lengthOfSide;

    public Square(final String name, final double lengthOfSide) {
        this.name = name;
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return lengthOfSide * lengthOfSide;
    }

    @Override
    public double getCircumference() {
        return 4 * lengthOfSide;
    }
}
