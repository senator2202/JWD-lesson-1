package com.Kharitonov123.Day123.Task9;

import java.util.Scanner;

/*Класс хранит радиус окружности, имеет методы
* вычисления длины и площади окружности*/
public class Task9 {
    private double radius;

    public Task9(double radius) {
        this.radius=radius;
    }

    /*Метод возвращает длину окружности*/
    public double circumference() {
        return 2*Math.PI*radius;
    }

    /*Метод возвращает площадь круга*/
    public double circleArea() {
        return Math.PI*radius*radius;
    }

    //Точка входа в программу, демонстрация работы
    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        Task9 task;
        System.out.println("Enter circle radius: ");
        task=new Task9(scanner.nextDouble());
        System.out.println("circle area: "+task.circleArea());
        System.out.println("circumference: "+task.circumference());
    }
}
