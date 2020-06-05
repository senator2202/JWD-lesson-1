package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Month;
import com.kharitonov.lesson1.validator.DateTimeValidator;

public class DateTimeService {
    /*Method returs number of days in month of definite year*/
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
    public int[] splitSeconds(int totalSeconds) {
        if (!new DateTimeValidator().validateDaySeconds(totalSeconds)) {
            throw new NumberFormatException("Number of seconds must be" +
                    "between 0 and 86400!");
        }
        int[] time = new int[3];
        time[0] = totalSeconds / 3600;//hours
        time[1] = (totalSeconds - (time[0] * 3600)) / 60;//minutes
        time[2] = totalSeconds - ((time[0] * 3600) + (time[1] * 60));//seconds
        return time;
    }

}
