package com.home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
class IntegerPalindromeTest {

    @Test
    void isPalindrome() {
        assertFalse(IntegerPalindrome.isPalindrome(-1));
        assertTrue(IntegerPalindrome.isPalindrome(1));
        assertTrue(IntegerPalindrome.isPalindrome(123321));
        assertTrue(IntegerPalindrome.isPalindrome(12321));
    }
}