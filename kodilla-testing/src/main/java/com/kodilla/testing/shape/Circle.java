package com.kodilla.testing.shape;

import static java.lang.Math.PI;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius) {
        if(radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("The radius of circle is unset.");
        }
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName(){
        return "Circle";
    }

    @Override
    public double getField(){
        return PI*radius*radius;
    }

}
