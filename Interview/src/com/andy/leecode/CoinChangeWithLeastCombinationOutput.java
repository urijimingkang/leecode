package com.andy.leecode;

public class CoinChangeWithLeastCombinationOutput {
    public static void main(String[] ss){
        int amount =11;
        int[] coins=new int[]{1,2,5,6};
        System.out.println(change(5,coins));
    }
    public static int change(int amount, int[] coins) {
        int [][] T=new int[coins.length][amount];
        if (coins == null || coins.length == 0) {
            return amount == 0? 1: 0;
        }

        for (int i = 0; i < coins.length; i ++) {
            for (int j = 1; j < amount; j ++) {
                if(i==0){
                    T[i][j]=j;
                }else {
                    if (j >= coins[i]) {
                        T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - coins[i]]);
                    } else {
                        T[i][j] = T[i - 1][j];
                    }
                }
            }
        }
        return T[coins.length-1][amount-1];
    }
}
