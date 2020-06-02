package com.com.kharitonov.lesson1.main;

import com.com.kharitonov.lesson1.console.DateTimeConsole;
import com.com.kharitonov.lesson1.service.DateTimeService;
import com.com.kharitonov.lesson1.validator.DateTimeValidator;

import java.io.IOException;

public class SecondTaskMain {
    /*Demonstration of task 2*/
    public static void main(String []args) {
        int month=4;
        int year=2020;
        try {
            DateTimeValidator validator=new DateTimeValidator();
            validator.validateMonth(month);
            validator.validateYear(year);
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }
        DateTimeService dateTimeService=new DateTimeService();
        int days=dateTimeService.getDays(month,year);
        boolean isLeap=dateTimeService.isLeapYear(year);
        DateTimeConsole dateTimeConsole=new DateTimeConsole();
        dateTimeConsole.printNumberOfDays(month, year, days);
        dateTimeConsole.printLeapYear(year, isLeap);
    }
}
