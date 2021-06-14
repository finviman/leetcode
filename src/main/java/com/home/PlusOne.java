package com.home;

public class PlusOne {

    public static void main(String[] args) {
        int[] s = {1, 9, 0, 9,9};
        plusOne(s);
        for (int i : s) {
            System.out.println(i);
        }
    }
    private static void plusOne(int[] digit) {
        int shift = 0;
        int plus = 1;
        for (int i = digit.length-1; i >= 0; i--) {
            int plused = digit[i]+plus+shift;
            if (plused == 10) {
                digit[i] = 0;
                shift = 1;
            }else {
                digit[i] = plused;
                shift=0;
            }
            plus=0;
        }
    }
}
