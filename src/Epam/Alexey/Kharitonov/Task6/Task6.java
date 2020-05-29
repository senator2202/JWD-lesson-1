package Epam.Alexey.Kharitonov.Task6;

import java.util.Scanner;

/*В классе хранится общее количество секунд,
* определяеся количество полных часов, минут и секунд.
* Класс предоставляет метод для вывода инфы на экарн*/
public class Task6 {
    private int totalSeconds;//общее количество секунд
    private int seconds;
    private int hours;
    private int minutes;

    public Task6(int totalSeconds) {
        this.totalSeconds=totalSeconds%86400;
        defineTime();
    }

    /*Скрытый метод, разбивает общее количество секунд
    * на часы,минуты и секунды. Вызывается из конструктора*/
    private void defineTime() {
        hours=totalSeconds/3600;
        minutes=(totalSeconds-(hours*3600))/60;
        seconds=totalSeconds-((hours*3600)+(minutes*60));
    }

    /*Печать прошедшего времени на экран*/
    public void printTime() {
        System.out.println(hours+" hours: "+minutes+" minutes: "
                +seconds+" seconds");
    }

    /*Точка входа в программу, демонстрация работы*/
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Task6 task;
        System.out.println("Enter total seconds: ");
        task = new Task6(scanner.nextInt());
        task.printTime();
    }
}
