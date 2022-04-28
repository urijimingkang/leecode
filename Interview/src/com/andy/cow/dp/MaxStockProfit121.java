package com.andy.cow.dp;

public class MaxStockProfit121 {
    public static void main(String []ss){
int[] prices={7,1,5,3,6,4};                           // 7  1 5 3 4 6 4
        System.out.println(maxProfit(prices,2));
        //Stack stack=new LinkedList();

    }
    public  static int maxProfit(int[] prices,int N) {
        int[][] localmax=new int[prices.length][N+1];
        int[][] globalmax=new int[prices.length][N+1];
        for (int i = 1; i <prices.length; i++) {
            for (int j = 1;j <=N; j++) { //N表示共次交易
                int tmp=prices[i]-prices[i-1];
                //local[i][j]表示最后一次卖出在今天的最大利益，局部最优。
               //localmax表示最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）
                localmax[i][j] = Math.max(localmax[i-1][j]+tmp,globalmax[i-1][j-1]+Math.max(tmp,0));
                //global[i][j]表示全局最优
               //globalmax一个是当前到达第i天可以最多进行j次交易，最好的利润是多少
                globalmax[i][j] = Math.max(localmax[i][j],globalmax[i-1][j]);

                

            }
            System.out.println("i="+i+" "+localmax[i][1]+" "+localmax[i][2]);
            System.out.println("i="+i+" "+globalmax[i][1]+" "+globalmax[i][2]);

           /* i=1 0 0
            i=1 0 0
            i=2 4 4
            i=2 4 4
            i=3 2 4
            i=3 4 4
            i=4 5 7
            i=4 5 7
            i=5 3 5
            i=5 5 7*/
        }

        return globalmax[prices.length-1][N];
    }
    public  static int maxProfitOneTime(int[] prices) {
        int min=prices[0];
        int ret=0;
        for (int i = 1; i <prices.length; i++) {
            min=Math.min(prices[i],min);
            ret=Math.max(prices[i]-min,ret);
        }

        return ret;
    }
    public  static int maxProfitNoLimit(int[] prices) {

        int ret=0;
        for (int i = 1; i <prices.length; i++) {

            ret+=Math.max(prices[i]-prices[i-1],0);
        }

        return ret;
    }
}
