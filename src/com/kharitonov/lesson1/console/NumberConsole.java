package com.kharitonov.lesson1.console;

public class NumberConsole {
    public void printLastDigitOfSquare(int number, int digit) {
        System.err.printf("Last digit of the square" +
                " of the number %d is %d", number, digit);
    }

    public void printResultForTwoEven(boolean flag, int... numbers) {
        System.out.print("It is " + flag +
                " that there are two even numbers among ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public void printPerfect(int number, boolean flag) {
        System.out.println("The number " + number + " is perfect: " + flag);
    }
}
