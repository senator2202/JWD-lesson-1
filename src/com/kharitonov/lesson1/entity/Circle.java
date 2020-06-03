package com.kharitonov.lesson1.entity;

public class Circle extends Shape {
    private double radius;
    private double circumference;

    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;

    }

    public double getCircumference() {
        return circumference;
    }
}
