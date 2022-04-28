package com.andy.cow.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindSum {
    public static void main(String[] args) {
int[] arr=new int[]{ 1,1 ,4 ,3,2,2 ,5 };

      //  List<List<Integer>> res=    findTwoSum(arr,5);
      // List<List<Integer>> res=    findThreeSum(arr,5);
      List<List<Integer>> res=  findNSum(arr,5,3);
        System.out.println(res);
    }

    //method findTwoSum
    public static  List<List<Integer>>  findTwoSum(int[]arr , int target) {
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();


        for (int i = 0; i <arr.length ; i++) {
            int tmp=target-arr[i];

            if(map.containsKey(tmp))
            {
                List lst=new ArrayList<>();
                lst.add(tmp);
                lst.add(arr[i]);
                res.add(lst);

            }
            else{
                map.put(arr[i],i);
            }

        }
        return res;
    }

// method findThreeSum
    public static  List<List<Integer>>  findThreeSum(int[]arr , int target) {
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <arr.length ; i++) { //1 2 3 4
            if(i>0&&arr[i]==arr[i-1]) continue;
            List<List<Integer>> tmp= findTwoSum(arr,i+1,target-arr[i]);
            for (List<Integer> lst:
                tmp ) {
                lst.add(arr[i]);
            }
            res.addAll(tmp);
        }
        return res;
    }
    public static  List<List<Integer>>  findTwoSum(int[]arr , int start,int target) {
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = start; i <arr.length ; i++) {

            int tmp=target-arr[i];

            if(map.containsKey(tmp))
            {
                List lst=new ArrayList<>();
                lst.add(tmp);
                lst.add(arr[i]);
                res.add(lst);

            }
            else{
                map.put(arr[i],i);
            }

        }
        return res;
    }
    //method findNSum

    public static  List<List<Integer>>  findNSum(int[]arr , int target,int NUM) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
         List<List<Integer>> res=new ArrayList<>();
        dfs(arr,0,new ArrayList<Integer>(),res,target,NUM);
        return res;
    }
    public static  void dfs(int[]arr ,int index,List<Integer> cur, List<List<Integer>> res,int target,int NUM) {

        for (int i = index; i <arr.length ; i++) {
            if(cur.size()==NUM)
            {
                int tmp=0;
                for (int j = 0; j < NUM;j++) {
                    tmp+=cur.get(j);
                }
                if(tmp==target)
                    res.add(new ArrayList<>(cur));
                return ;
            }
            if(i>index&&arr[i]==arr[i-1]) continue;
            cur.add(arr[i]);
            dfs(arr,i+1,cur,res,target,NUM);
            cur.remove(cur.size()-1);
        }




    }
}
