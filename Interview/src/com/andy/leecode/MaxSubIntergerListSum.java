package leecode;

public class MaxSubIntergerListSum {
    public static void main(String[]ss){
      int[] aa=  new int []{1,2,-1,3,-4};
        System.out.println(maxSubIntergerListSum(aa));
    }
    public static int maxSubIntergerListSum(int[]a){
        int max=0;
        int tmp_sum=0;
        for(int i=0;i<a.length;i++){
            tmp_sum+=a[i];
            if(tmp_sum>max)
                max=tmp_sum;
            if(tmp_sum<0)
                tmp_sum=0;
        }

        return max;
    }
}
