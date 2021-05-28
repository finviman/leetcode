package com.home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
class RemoveElementTest {

    @Test
    void removeElement() {
        int[] nums = {0,1,2,3,3,0,4,2};
        final int count = RemoveElement.removeElement(nums, 3);
        System.out.println(count);
    }
}