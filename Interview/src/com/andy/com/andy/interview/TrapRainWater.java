package com.andy.com.andy.interview;

/**
 * Created by aweng on 8/17/2016.
 */
public class TrapRainWater {

    /*

    题目描述：
看下面这个图片，在这个图片里我们有不同高度的墙。
这个图片由一个整数数组所代表，数组中每个数是墙的高度。上边的图可以表示为数组[2,5,1,2,3,4,7,7,6]，假如开始下雨了，那么墙之间的水坑能够装多少水呢？”
面试题分析：我的Twitter技术面试失败了

                |
                |						 __
                |                 水    |  |
                |		  __            |  |__    __
                |		 |	|           |  |  |  |  |
                |	__	 | 	|__	   __   |  |  |__|  |__
                |  |  |	 |	|  |  |  |  |  |  |  |  |  |
                |__|__|__|__|__|__|__|__|__|__|__|__|__|_____
                1  2  3  4  5  6  7  8  8  9  10 11 12
               // int array[]={0,1,0,2,1,0,1,3,2,1,2,1};
    ����������һ������Ϊ[0,1,0,2,1,0,1,3,2,1,2,1]��ÿ��Ԫ�ش������ӵĸ߶�
    ������ķ���ֵΪ6

    ˼·������������������ҵ���ߵ�����λ�ã���ô����ͷ��ʼ�ҿ���
    ʢˮ�Ķ��٣������ͷ��ʼ��������Ҫ������������ߵ�λ�ã���������ǰλ��
    ������ֵ�ǰ�����ӱ�֮ǰ��¼�����Ӹߣ���ô����
    ���û��֮ǰ��¼�����Ӹߣ���ô�Ϳ��Լ��㵱ǰ�������֮ǰ�ĸ����ӵ�ʢˮ��
    */
    public static int TrapRainWater(int[] vec)
    {
        int i,maxhigh;
        maxhigh = 0;
        int left=0,right = 0;
        int sum =0;
        for(i=0;i<vec.length;i++)
            if(vec[i] > vec[maxhigh])
                maxhigh = i;

        for(i=0;i<maxhigh;i++)
        {
            System.out.println("sum in left:"+sum);
            if(vec[i] < left)
                sum +=(left-vec[i]);
            else
                left = vec[i];
        }

        for(i=vec.length-1;i>maxhigh;i--)
        {
            if(vec[i]<right)
                sum += (right-vec[i]);
            else
                right = vec[i];
        }
        return sum;
    }

    public static void main(String []ss)
    {

        int array[]={0,1,0,2,1,0,1,0,2,1,2,1};
      //  int array[]={2,5,1,2,3,4,7,7,6};
        // vector<int> vec(array,array+sizeof(array)/sizeof(int));

        System.out.println(TrapRainWater(array));
    }
}
