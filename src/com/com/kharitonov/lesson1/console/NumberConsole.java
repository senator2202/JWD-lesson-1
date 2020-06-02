package com.com.kharitonov.lesson1.console;

public class NumberConsole {
    public void printLastDigitOfSquare(int number, int digit) {
        System.err.printf("Last digit of the square of the number %d is %d", number, digit);
    }

    public void printReslutForTwoEven( boolean flag, int ... numbers) {
        System.out.print("It is "+flag+" that there are two even numbers among ");
        for (int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}
