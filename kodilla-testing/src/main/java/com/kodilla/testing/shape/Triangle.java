package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private double base;
    private double height;

    public Triangle(double base, double height) {
        if(base > 0 && height > 0) {
            this.base = base;
            this.height = height;
        } else {
            System.out.println("The base and height of triangle are unset.");
        }
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.base, base) != 0) return false;
        return Double.compare(triangle.height, height) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(base);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String getShapeName(){
        return "Triangle";
    }

    @Override
    public double getField(){
        return base*height/2;
    }

}
