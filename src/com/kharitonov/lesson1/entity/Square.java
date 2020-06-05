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

}
