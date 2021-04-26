package com.example.nav.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
//        System.out.println("----------");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
        simpleDateFormat.setLenient(false);
        Date date = new Date();

        System.out.println(simpleDateFormat.format(date));

        date = simpleDateFormat.parse("2020-01-02 02:03:01");

        System.out.println(date.getYear() + 1900 + "  " + simpleDateFormat.format(date));

        date.setYear(2021);
//        date.setMonth(1);
//        date.setDate(2);
//        System.out.println(date.getYear()+"  "+date.getMonth()+"   "+date.getDate());
//
//        date=simpleDateFormat.parse();
//


    }
}
