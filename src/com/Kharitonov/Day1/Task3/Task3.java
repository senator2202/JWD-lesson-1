package com.Kharitonov.Day1.Task3;

import java.util.Scanner;

/*Класс хранит площадь описанного квадрата и его сторону,
* предоставляет методы вычисления площади вписанного квадрата
* и соотношение 2 площадей*/
public class Task3 {
    /*сторона описанного квадрата, он же диаметр вписанной окружности*/
    private double side;
    private double area;//площадь заданного квадрата

    public Task3(double area) {
        side=Math.sqrt(area);
        this.area=area;
    }

    /**Метод вычисляет площадь вписанного
     * в окружность квадарат по формуле D^2/2*/
    public double inscribedSquareArea() {
        return side*side/2;
    }

    /*Метод вычисляет, во сколько раз площадь вписанного
    * квадрата меньше площади заданного*/
    public double areaScale() {
        return area/inscribedSquareArea();
    }

    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        Task3 task;
        double area;
        System.out.println("Enter square area: ");
        area = scanner.nextDouble();
        while (area<0) {
            System.out.println("Wrong value!!! Enter it again!!!");
            area= scanner.nextDouble();
        }

        task=new Task3(area);
        System.out.println("Area of inscribed square: "
                +task.inscribedSquareArea());
        System.out.println("Described/inscribed area scale: "
                +task.areaScale());
    }
}
