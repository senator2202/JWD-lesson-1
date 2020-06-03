package com.kharitonov.lesson1.entity;

public class Square extends Shape {
    private double side;
    private double diagonal;

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
        area = Math.pow(side, 2);
        diagonal = Math.sqrt(2) * side;
    }

    public double getDiagonal() {
        return diagonal;
    }

}
