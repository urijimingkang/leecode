package com.andy.tiger;
/*Example 1:

        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Subsets_Leetcode78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  ret=new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        help(ret,tmp,nums,0);
        return ret;


    }
    //DFS
    public static void help(  List<List<Integer>> ret,ArrayList<Integer> tmp,int[] nums,int start ){
        //if(tmp)
        ret.add(new ArrayList<>(tmp));
        for (int i = start; i <nums.length; i++) {
            tmp.add(nums[i]);
            help(ret,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
