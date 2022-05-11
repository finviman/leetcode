package com.home.dp;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int n = 40;
        int[] memo = new int[41];
        int F40 = f.fibonacciRecursionWithMemo(n,memo);
        System.out.println(F40);
//        int F399 = f.fibonacciRecursion(39);
//        System.out.println(F399*.1/F400);
    }

    /**
     * 单纯递归，大量重复计算。计算超慢。
     * @param n
     * @return
     */
    public int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    /**
     * 带备忘录的计算
     */
    public int fibonacciRecursionWithMemo(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }else if (n == 1 || n == 2) {
            memo[n] = 1;
            return 1;
        } else {
            if(memo[n]==0){
                memo[n] = fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
            }
            return memo[n];
        }
    }
}
