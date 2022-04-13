package com.home;

/**
 * Created by liyang on 24/9/2017.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        long ori = 0;
        long reversed = reverseInt(ori);
        System.out.println("----"+reversed);
    }

    private static long reverseInt(long ori) {
        if (ori < 10) {
            return  ori;
        }else{
            long inter = reverseInt(ori / 10);
            System.out.println(inter);
            return ori % 10 * ((int) Math.pow(10, getBits(ori/10))) + inter;
        }
    }

    private static long getBits(long a) {
        long bits =1;
        while (a >= 10) {
            a=a/10;
            bits++;
        }
        return bits;
    }


}
