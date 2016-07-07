package com.andy.com.andy.interview;

import com.andy.datastructure.LinkNode;

/**
 * Created by aweng on 7/6/2016.
 */
public class CheckSymNumber {
    public static void main(String [] args){
        int a=124321;
        System.out.println(isSymNumber(a));

    }
    public static boolean isSymNumber(int a) {
        int length = getLenOfNumber(a);
        int len = length;
        System.out.println(len);

        int b = 0, c = 0; boolean flag = true;

        for (int i = 1; len > 0; i++) {

            b = a / power(len - 1);
            c = a % power(1);


            System.out.println("b=" + b + " c=" + c + " len=" + len);
            System.out.println("(a%power(len-i))" + (a % power(len - i)));
            a = a % power(len - 1);
            System.out.println("(a/power(i))" + (a / power(i)));
            a = a / power(1);
            len = getLenOfNumber(a);
            if (b != c) {
                flag = false;
                break;

            }
            
        }
        return flag;
    }


    public static int getLenOfNumber(int a){
        int i=0;
        while(a!=0){
            a/=10;
            i++;
        }
        return i;
    }
    public static int power(int a){
        int result=1;
        while(a>0){
            result *=10;
            a--;
        }
        return result;
    }
}
