package com.Kharitonov.Day1.Task4;

import java.util.Scanner;

/*Класс хранит 4 значения, и предоставляет метод проверки,
* есть ли среди них 2 четных*/
public class Task4 {
    private int a;
    private int b;
    private int c;
    private int d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    /*Метод проверяет, есть ли среди 4 чисел хотя бы 2 четных*/
    public boolean hasTwoEven() {
        int count=0;
        if (a%2==0) {
            count++;
        }
        if (b%2==0) {
            count++;
        }
        if (c%2==0) {
            count++;
        }
        if (d%2==0) {
            count++;
        }

        return (count>=2) ? true : false;
    }

    /*Точка входа в программу, демонстрация работы*/
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Task4 task=new Task4();
        String result;

        System.out.println("Enter A: ");
        task.setA(scanner.nextInt());
        System.out.println("Enter B: ");
        task.setB(scanner.nextInt());
        System.out.println("Enter C: ");
        task.setC(scanner.nextInt());
        System.out.println("Enter D: ");
        task.setD(scanner.nextInt());

        System.out.println(task.hasTwoEven());
    }
}
