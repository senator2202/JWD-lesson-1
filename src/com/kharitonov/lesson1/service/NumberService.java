package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.validator.ValueValidator;

import java.util.ArrayList;

public class NumberService {

    /*Method returns last digit of the square of the number*/
    public int getLastDigitOfSquare(int number) {
        int digit = defineLastDigit(number);
        return defineLastDigit((int) Math.pow(digit, 2));
    }

    /*Method returns last digit of the number*/
    private int defineLastDigit(int number) {
        return number % 10;
    }

    /*Method checks numbers for at least two of them to be even*/
    public boolean checkForTwoEven(int... numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        return (count > 1);
    }

    /*Метод, проверяющий число на совершенство*/
    public boolean isPerfect(int number) {
        if (!new ValueValidator().validateNaturalValue(number)) {
            throw new NumberFormatException("The number is not natural!");
        }
        int sum = 0;
        ArrayList<Integer> dividers = getDividers(number);
        for (Integer i : dividers) {
            sum += i;
        }
        return (sum == number);
    }

    /*Метод, возвращающий список делителей*/
    private ArrayList<Integer> getDividers(int number) {
        ArrayList<Integer> dividers = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                dividers.add(i);
            }
        }
        return dividers;
    }
}
