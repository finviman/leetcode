package com.home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
public class IntegerPalindrome {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        List<Integer> listDigit = new ArrayList<>();
        while (x > 0) {
            listDigit.add(x % 10);
            x = x /10;
        }
        int size = listDigit.size();
        for (int i = 0; i < size >> 1; i++) {
            if (listDigit.get(i) != listDigit.get(size-1-i)) {
                return false;
            }
        }
        return true;
    }
}
