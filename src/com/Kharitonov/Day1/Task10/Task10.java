package com.Kharitonov.Day1.Task10;

import java.util.Scanner;

/*Класс хранит начало отрезка, его конец, шаг функции,
* а также имеет метод для вывода значений функции на отрезке с шагом*/
public class Task10 {
    private double a;
    private double b;
    private double h;


    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setH(double h) {
        this.h = h;
    }

    /*Метод выводит значения функции на отрезке с шагом*/
    public void printFunction() {
        System.out.println("for F(x)=tan(x):\n");
        for (double i=a; i<=b; i+=h) {
            System.out.println("x="+i+"; F(x)="+Math.tan(i));
        }
    }

    /*Точка входа в программу, демонстрация работы*/
    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        Task10 task=new Task10();
        System.out.print("Enter start of segment: a=");
        task.setA(scanner.nextDouble());
        System.out.print("\nEnter end of segment: b=");
        task.setB(scanner.nextDouble());
        System.out.print("\nEnter step: h=");
        task.setH(scanner.nextDouble());
        task.printFunction();
    }
}
