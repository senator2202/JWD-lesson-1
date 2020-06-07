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
        ValueValidator valueValidator = new ValueValidator();
        if (!valueValidator.validateInRange(number)) {
            throw new NumberFormatException("Number must be in range "
                    + valueValidator.getRange());
        }
        return number % 10;
    }

    /*Method checks numbers for at least two of them to be even*/
    public boolean checkForTwoEven(int... numbers) {
        int count = 0;
        for (int number : numbers) {
            ValueValidator valueValidator = new ValueValidator();
            if (!valueValidator.validateInRange(number)) {
                throw new NumberFormatException("All numbers must be " +
                        "in range " + valueValidator.getRange());
            }
            if (number % 2 == 0) {
                count++;
            }
        }
        return (count > 1);
    }

    /*Метод, checking if the number is perfect*/
    public boolean isPerfect(int number) {
        if (number <= 0) {
            throw new NumberFormatException("The number is not natural!");
        }
        int sum = 0;
        ArrayList<Integer> dividers = getDividers(number);
        for (Integer i : dividers) {
            sum += i;
        }
        return (sum == number);
    }

    /*Method returns dividers of the number*/
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
