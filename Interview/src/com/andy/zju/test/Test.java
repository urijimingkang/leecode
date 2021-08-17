package com.andy.zju.test;

import com.sun.scenario.effect.Brightpass;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
int[] arr=new int[]{ 1 ,2 ,5 ,4 ,3,6,9,8};
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
            if(low<0|| high>=arr.length||high-low<1)
                return;
            int i=low;
            int stand=arr[low];
            //int pilot=arr[high];
            int j=high;
            while(i!=j){

                while(arr[j]>=stand&&i<j) j--;
                while(arr[i]<=stand &&i<j) i++;
                if(i<j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }


            arr[low]=arr[i];
            arr[i]=stand;

            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);

        }
}
