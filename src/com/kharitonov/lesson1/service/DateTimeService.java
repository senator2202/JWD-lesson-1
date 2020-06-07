package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Month;
import com.kharitonov.lesson1.entity.Time;
import com.kharitonov.lesson1.validator.DateTimeValidator;

public class DateTimeService {
    /*Method returns number of days in month of definite year*/
    public int getDays(int month, int year) {
        DateTimeValidator dateTimeValidator = new DateTimeValidator();
        if (!dateTimeValidator.validateMonth(month)) {
            throw new NumberFormatException("Wrong month value! " +
                    "It must be between 1 and 12!");
        }
        if (!dateTimeValidator.validateYear(year)) {
            throw new NumberFormatException("Wrong year value! " +
                    "It must be > 0!");
        }
        return (isLeapYear(year) && month == 2)
                ? Month.values()[month - 1].getDays() + 1
                : Month.values()[month - 1].getDays();
    }

    /*Method returns true if the year is leap*/
    public boolean isLeapYear(int year) {
        if (!new DateTimeValidator().validateYear(year)) {
            throw new NumberFormatException("Wrong year value!" +
                    " It must be > 0!");
        }
        return (year % 4 == 0);
    }

    /*Method splits seconds into hours, minutes, seconds*/
    public Time splitSeconds(int totalSeconds) {
        if (!new DateTimeValidator().validateDaySeconds(totalSeconds)) {
            throw new NumberFormatException("Number of seconds must be" +
                    "between 0 and 86400!");
        }
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds - (hours * 3600)) / 60;
        int seconds = totalSeconds - ((hours * 3600) + minutes * 60);
        return new com.kharitonov.lesson1.entity.Time(hours, minutes, seconds);
    }

}
