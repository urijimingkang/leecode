package com.andy.interview;

/**
 * Created by aweng on 8/16/2016.
 */

import java.util.Date;

public class ImmutableTest {
    public static void main(String[] ss) {
        Date myDate = new Date();
        BrokenPerson myPerson = new BrokenPerson("David", "O'Meara", myDate);
        System.out.println(myPerson.getDOB());
        Date mydate2 = myPerson.getDOB();
        mydate2.setMonth(mydate2.getMonth() + 1);
        System.out.println(myPerson.getDOB());
        String st="hello";
       String str2= String.valueOf(13);
        System.out.println(str2);
    }


}
