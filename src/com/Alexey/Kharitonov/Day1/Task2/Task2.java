package com.Alexey.Kharitonov.Day1.Task2;

import java.util.Scanner;

/*  Класс хранит данные о номере месяца и годе,
    предоставляет метод для определения количества дней в месяце,
    а также метод для проверки високосности*/
public class Task2 {
    private int year;//порядковый номер месяца
    private int month;//год

    /*Конструктор с параметрами месяц, год*/
    public Task2(int month, int year) {
        this.month=month;
        this.year=year;
    }

    /*Метод вовзраащет количество дней в текущем месяце*/
    public int  defineDays() {
        int daysNumber=0;
        switch (month) {
            case 1:
                daysNumber=31;
                break;

            case 2:
                daysNumber = (year%4==0) ? 29 : 28;
                break;

            case 3:
                daysNumber=31;
                break;
            case 4:
                daysNumber=30;
                break;

            case 5:
                daysNumber=31;
                break;

            case 6:
                daysNumber=30;
                break;

            case 7:
                daysNumber=31;
                break;

            case 8:
                daysNumber=31;
                break;

            case 9:
                daysNumber=30;
                break;

            case 10:
                daysNumber=31;
                break;

            case 11:
                daysNumber=30;
                break;

            case 12:
                daysNumber=31;
                break;

            default:
                break;
        }

        return daysNumber;
    }

    /*Метод проверяет год на високосность*/
    public boolean isLeapYear() {
        return (year%4==0) ? true : false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    /*Точка входа в программу, демонстарция работы*/
    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        Task2 task;
        int month;
        int year;

        System.out.println("Enter number of month: ");
        month=scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Wrong month number!!! Enter it again!!!");
            month=scanner.nextInt();
        }
        System.out.println("Enter year: ");
        year=scanner.nextInt();
        while (year<=0) {
            System.out.println("Wrong year!!! Enter it again!!!");
            year=scanner.nextInt();
        }

        task=new Task2(month,year);
        System.out.println("There are "+task.defineDays()+" days in "
                +task.getMonth()+" month of "+task.getYear()+" year.");
        if (task.isLeapYear()) {
            System.out.println(task.getYear()+" year is leap.");
        } else {
            System.out.println(task.getYear()+ " year is not leap.");
        }
    }
}
