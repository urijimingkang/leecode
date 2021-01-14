package com.andy.interview;

/**
 * Created by aweng on 7/6/2016.
 */
public class CheckSymNumber {
    public static void main(String [] args){
        int a=124321;
        System.out.println(isSymNumber(a));

    }
    //判断一个数是否回文
    public static boolean isSymNumber(int a) {
        int length = getLenOfNumber(a);
        int len = length;
        System.out.println(len);

        int b = 0, c = 0; boolean flag = true;

        for (int i = 1; len > 0; i++) {

            b = a / power(len - 1);
            c = a % power(1);


            System.out.println("b=" + b + " c=" + c + " len=" + len);
            a = a % power(len - 1);  //去掉头一个数
            a = a / power(1);         //去掉尾部一个数
            len = getLenOfNumber(a);
            if (b != c) {
                flag = false;
                break;

            }

        }
        return flag;
    }

    //判断一个数是否回文，递归方式，没解决，有时间再做
    public static boolean isSymNumber2(int a) {
        int length = getLenOfNumber(a);
        int len = length;
        System.out.println(len);

        int b = 0, c = 0;

        boolean flag = true;
        if (a > 0) {

            b = a / power(len - 1);
            c = a % power(1);

            a = a % power(len - 1);  //去掉头一个数
            a = a / power(1);         //去掉尾部一个数
            len = getLenOfNumber(a);


            flag = isSymNumber2(a);
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
