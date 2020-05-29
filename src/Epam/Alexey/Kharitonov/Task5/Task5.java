package Epam.Alexey.Kharitonov.Task5;


import java.util.ArrayList;
import java.util.Scanner;

/*Класс хранит число и предоставляет метод для определения его совершенства*/
public class Task5 {
    private int number;// собственно само число

    public Task5(int number) {
        this.number=number;
    }

    /*Метод, проверяющий число на совершенство*/
    public boolean isPerfect() {
        int sum=0;
        ArrayList<Integer> dividers=getDividers();
        for (Integer i : dividers) {
            sum+=i;
        }
        return (sum==number) ? true : false;
    }

    /*Метод, возвращающий список делителей*/
    private ArrayList<Integer> getDividers() {
        ArrayList<Integer> dividers=new ArrayList<>();
        for (int i=1; i<number; i++) {
            if (number%i==0) {
                dividers.add(i);
            }
        }
        return dividers;
    }

    /*Точка входа в программу, демонстрация работы*/
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Task5 task;
        System.out.println("Enter number: ");
        task=new Task5(scanner.nextInt());
        System.out.println(task.isPerfect());
    }
}
