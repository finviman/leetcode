package com.home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        String[] strs = {"aa", "a"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }
}