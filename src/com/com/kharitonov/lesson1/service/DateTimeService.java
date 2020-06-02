package com.com.kharitonov.lesson1.service;

import com.com.kharitonov.lesson1.entity.MonthDays;

public class DateTimeService {
    /*Метод вовзраащет количество дней в текущем месяце*/
    public int  getDays(int month, int year) {
        return (isLeapYear(year) && month==2)
                ? MonthDays.values()[month-1].getDays()+1
                : MonthDays.values()[month-1].getDays();
    }

    public boolean isLeapYear(int year) {
        return (year%4==0) ? true : false;
    }
}
