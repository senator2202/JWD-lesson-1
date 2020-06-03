package com.kharitonov.lesson1.entity;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint(){}

    public MyPoint(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceFromOrigin() {
        return Math.hypot(x,y);
    }
}
