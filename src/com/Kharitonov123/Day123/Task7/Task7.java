package com.Kharitonov123.Day123.Task7;

import java.util.Scanner;

/*Класс хранит координаты 2 точек и предоставляет метод для определения,
* которая из точек находится ближе к началу координат*/
public class Task7 {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    /*Метод возвращает имя точки с наименьшим расстоянием до начала координат*/
    public String closestPoint() {
        double distance1=Math.sqrt((x1*x1)+(y1*y1));
        double distance2=Math.sqrt((x2*x2)+(y2*y2));
        return (distance1<distance2) ? "A" : "B";
    }

    /*Точка входа в программу, демонстрация работы*/
    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        Task7 task=new Task7();
        System.out.print("Enter coordinates of point A: \n"
                +"x1=");
        task.setX1(scanner.nextInt());
        System.out.print("\ny1=");
        task.setY1(scanner.nextInt());
        System.out.print("\nEnter coordinates of point B: \n"
                +"x2=");
        task.setX2(scanner.nextInt());
        System.out.print("\ny2=");
        task.setY2(scanner.nextInt());

        System.out.println("\nPoint "+task.closestPoint()
                +" closer to origin! ");
    }

}
