package com.Kharitonov.Day1.Task1;

import java.util.Scanner;

/*Класс хранит число, его последнюю цифру,
* и предоставляет метод для нахождения последней цифры квадарата этого числа*/
public class Task1 {

    private int number;//само число
    private int lastDigit;//последняя цифра в этом числе

    /*Конструктор, в который сразу передается число*/
    public Task1(int number) {
        this.number=number;
        lastDigit=defineLastDigit(number);
    }

    /*Метод возвращает последнюю цифру апередаваемого числа*/
    private int defineLastDigit(int number) {
        String string=Integer.toString(number);
        return string.toCharArray()[string.length()-1]-48;
    }

    /*Метод вовзращает последнюю цифру квадрата числа,
    * которое хранитсяч в объекте*/
    public int getLastDigitOfSquare() {
        return defineLastDigit(lastDigit*lastDigit);
    }

    /*Точка входа, демонстрация работы с классом*/
    public static void main (String []args){
        int number;
        Scanner scanner=new Scanner(System.in);
        Task1 task;
        System.out.println("Enter number: ");
        number=scanner.nextInt();
        task=new Task1(number);
        System.out.println("Last digit of squared number: "
                +task.getLastDigitOfSquare());
    }
}
