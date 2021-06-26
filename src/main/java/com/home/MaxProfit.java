package com.home;

public class MaxProfit {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    private static int maxProfit(int[] prices){
        int mini = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>mini){
                if(prices[i]-mini>maxProfit)
                    maxProfit = prices[i]-mini;
            }else{
                mini = prices[i];
            }
        }
        return maxProfit;
    }
}
