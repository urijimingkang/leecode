package com.andy.com.andy.interview;

/**
 * Created by aweng on 8/17/2016.
 */
public class DPWaterTest {

    /*

    题目要求：
	给出一系列非负整数a1, a2, ..., an,
	每一个数都代表数轴上的一个点(i, ai)，
	那么这n个垂直线中的任意两个都可以组成一个区间，然后和x轴可以构成一个容器，求出可以盛水最多的容器的两条边。

     */
    public static int boardContainer(int []a){
        int low=0;
        int high=a.length-1;
        int res=0;
        while(low<high)
        {
            if(Math.min(a[low], a[high])*(high-low)>res)
            {
                res=Math.min(a[low], a[high])*(high-low);
            }
            if(a[low]<a[high])
                low++;
            else
                high--;


        }
        return res;
    }
    public static void main(String []ss){
        int a[]={4,3,4,5,7,9,7,6,8,5,3,2};
      //  int a[]={4,1,3,2};

System.out.println(boardContainer(a));
    }


}
