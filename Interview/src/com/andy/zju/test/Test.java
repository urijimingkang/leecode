package com.andy.zju.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
int[] arr=new int[]{ 1 ,2 ,5 ,4 ,3};
quicksort(arr,0,arr.length-1);
        System.out.println(arr);
    }
    /*public static void subset2(List<List<Integer>>res, int[] ast, List<Integer> cur, int index) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i <ast.length ; i++) {
            cur.add(ast[index]);
            subset2(res,  ast,  cur,  i+1);
cur.remove(cur.size()-1);
        }
    }*/
    // 1 2 3 4  5
    //  1 2 3  5 4  nlogn

        public static void  quicksort(int[]arr,int low,int high){
            int i=low;
            int pilot=arr[high];
            int j=high;
            while(i!=j){
                while(arr[i]<pilot &&i<j) i++;
                while(arr[j]>pilot&&i<j) j--;
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }

            int tmp2=arr[j];
            arr[j]=pilot;
            pilot=tmp2;

            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);

        }
}
