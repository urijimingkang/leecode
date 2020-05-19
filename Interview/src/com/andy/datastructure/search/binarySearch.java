package com.andy.datastructure.search;

public class binarySearch {
    public static void main(String[] aa){
        int [] list=new int[]{1,4,7,9,10 ,15,19,20,21};
System.out.println(binarySearch(list,11));
    }
    public static String solve(int n,int k,String str1,String str2){

        //Write your code here
        if(n<=k){
            if(str2.contains(str1))
                return "YES";

        }

        return "NO"; //return type "String".
    }

    public static int binarySearch(int[] aa,int b){
        int ret=0;
        int i=0;
        int high=aa.length-1;
        int low=0;
        while(low<high){
            i=(high+low)/2;
            if(b<aa[i]){
                high=i-1;

            }else if(b>aa[i]){

                low=i+1;
            }else{
                ret=i;
                break;
            }


        }
        return ret;

    }
}
