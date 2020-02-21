package com.train.Class;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Time: 19-10-13下午4:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DateForClass {

    public static void main(String[] args) {
        Date date = new Date();
        String s = date.toString();
        System.out.println(s);
        LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
        System.out.println(newYearsEve);
        int year = newYearsEve.getYear();
        int month = newYearsEve.getMonthValue();
        int days = newYearsEve.getDayOfMonth();

        LocalDate aThousandDaysLater = newYearsEve.plusDays(1000);


    }
}
