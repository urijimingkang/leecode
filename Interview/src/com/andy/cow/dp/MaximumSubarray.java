
//https://leetcode-cn.com/problems/maximum-subarray/
package com.andy.cow.dp;

public class MaximumSubarray {

    public static void main(String[] args) {
        int [] a=new int[]{ -2,5,-3,4,-1,2,1,-5,4};
        int sum=a[0];
        int curr_sum=a[0];
        for (int i = 1; i <a.length ; i++) {
            curr_sum=Math.max(a[i],a[i]+curr_sum);

            sum=Math.max(curr_sum,sum);

        }
        System.out.println(sum);
    }


}
