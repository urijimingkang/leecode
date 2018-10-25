package com.andy.newds.sort;

public class Sort {
    public static int[] bubbleSort(int[] input ){
      for(int i=0;i<input.length;i++)
          for(int j=i;j<input.length;j++)
          {
              if(input[i]>input[j])
              {
                  int tmp;
                  tmp=input[i];
                  input[i]=input[j];
                  input[j]=tmp;
              }
          }
        return input;

    }

    public static int[] insertSort(int[] input ){

        for(int i=1;i<input.length;i++)
        {
            int tmp=input[i];
            int j=i-1;
            while (input[j]>tmp)
            {
                input[j+1]=input[j];
                j--;
            }
            input[j+1]=tmp;

        }

        return input;

    }
    public static void swap(int a,int b){
        int tmp;
        tmp=a;
        a=b;
        b=tmp;
    }

    public static void main(String[]ss){
        int[] nums =new int[] {2, 27, 18, 15};
        insertSort(nums);
        System.out.println(nums);
    }

}
