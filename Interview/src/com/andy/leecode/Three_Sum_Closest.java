package leecode;

public class Three_Sum_Closest {
    public static void main(String[]ss){
int[] a=new int[]{1,-2,3,4};
        System.out.println(Sum3Closest(a,3));
    }
    public static int Sum3Closest(int[]a,int target){
        int max=a[0]+a[1]+a[2];;
        int tmp_sum=0;
        for(int i=1;(i+1)<a.length&&(i+2)<a.length&&i<a.length-3;i++){
            tmp_sum+=a[i]+a[i+1]+a[i+2];

            int tmp_target=(tmp_sum-target)>0?tmp_sum-target:target-tmp_sum;
            int tmp_max=(max-target)>0?max-target:target-max;
            if(tmp_target<tmp_max)
                max=tmp_target;
            if(tmp_sum<0)
                tmp_sum=0;
        }
        return max;
    }
}
