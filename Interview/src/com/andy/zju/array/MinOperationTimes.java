package com.andy.zju.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class MinOperationTimes {
    public static void main(String[] args) {
//int[] arr=new int[]{ 1,1 ,2,2 ,5 ,4 ,3,6,9,8};
//quicksort(arr,0,arr.length-1);
// System.out.println(res);
        int[] arr=new int[]{ 3,2,1,2,1,7};
       // LinkedHashMap<Integer,Integer> map= minOperation(arr);
      //  int[] arr=new int[]{2,1,3,1,4,1};

        System.out.println(minOperation(arr));
    }

    public static int  minOperation(int[] arr){
        Arrays.sort(arr);
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i <arr.length ; i++) {
          //  map.computeIfPresent(arr[i],(key,val)->val+1);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        LinkedHashMap<Integer,Integer> newmap=new LinkedHashMap<>(map);

int cnt=0;
        while(newmap.values().stream().reduce(0, (a, b) -> a + b)>newmap.size()) {
            Set<Integer> set= map.keySet();
            for (Integer ket:
                 set) {
                while(newmap.get(ket)>1){
                    newmap.put(ket+1,newmap.getOrDefault(ket+1,0)+1);
                    newmap.put(ket,newmap.get(ket)-1);
                    cnt=1+cnt;
                }
            }
       map=new  LinkedHashMap<>(newmap);
        }
      //  System.out.println(cnt);
        return cnt;
    }
    /*public static void subset2(List<List<Integer>>res, int[] ast, List<Integer> cur, int index) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i <ast.length ; i++) {
            cur.add(ast[index]);
            subset2(res,  ast,  cur,  i+1);
cur.remove(cur.size()-1);
        }
    }*/

    //  1  3 2  5 4
/*
        public static void  quicksort(int[]arr,int low,int high){
            if(low<0|| high>=arr.length||high-low<1)
                return;
            int i=low;
            //int stand=arr[low];
            int stand=arr[high];
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

 */

}
