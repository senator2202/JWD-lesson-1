package com.kharitonov.lesson1.entity;

public class Square {
    private double side;

    public Square() {
    }

    public Square(double side) {
        setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return Math.pow(side, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return Double.compare(square.side, side) == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("side=").append(side);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }
}
