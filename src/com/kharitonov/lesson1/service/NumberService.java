package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.validator.ValueValidator;

import java.util.ArrayList;

public class NumberService {

    /*Method returns last digit of the square of the number*/
    public int getLastDigitOfSquare(int number) throws TaskException {
        int digit = defineLastDigit(number);
        return defineLastDigit((int) Math.pow(digit, 2));
    }

    /*Method returns last digit of the number*/
    private int defineLastDigit(int number) throws TaskException {
        ValueValidator valueValidator = new ValueValidator();
        if (!valueValidator.validateInRange(number)) {
            throw new TaskException("Number must be in range "
                    + valueValidator.getRange());
        }
        return number % 10;
    }

    /*Method checks numbers for at least two of them to be even*/
    public boolean checkForTwoEven(int... numbers) throws TaskException {
        int count = 0;
        for (int number : numbers) {
            ValueValidator valueValidator = new ValueValidator();
            if (!valueValidator.validateInRange(number)) {
                throw new TaskException("All numbers must be " +
                        "in range " + valueValidator.getRange());
            }
            if (number % 2 == 0) {
                count++;
            }
        }
        return (count > 1);
    }

    /*Метод, checking if the number is perfect*/
    public boolean isPerfect(int number) throws TaskException {
        if (number <= 0) {
            throw new TaskException("The number is not natural!");
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
