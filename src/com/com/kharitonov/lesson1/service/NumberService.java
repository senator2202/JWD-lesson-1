package com.com.kharitonov.lesson1.service;

public class NumberService {

    /*Method returns last digit of the square of the number*/
    public int getLastDigitOfSquare(int number) {
        int digit=defineLastDigit(number);
        return defineLastDigit((int) Math.pow(digit,2));
    }

    /*Method returns last digit of the number*/
    private int defineLastDigit(int number) {
        return number%10;
    }

    /*Method checks numbers for at least two of them to be even*/
    public boolean checkForTwoEven(int ... numbers) {
        int count=0;
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i]%2==0) {
                count++;
            }
        }
        if (count>1) {
            return true;
        }
        return false;
    }
}
