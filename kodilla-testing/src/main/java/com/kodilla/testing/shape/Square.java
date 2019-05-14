package com.kodilla.testing.shape;

public class Square implements Shape {

    private double side;

    public Square(double side) {
        if(side > 0) {
            this.side = side;
        } else {
            System.out.println("The side of square is unset");
        }
    }

    public double getSide() {
        return side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.side, side) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName(){
        return "Square";
    }

    @Override
    public double getField(){
        return side*side;
    }
}
