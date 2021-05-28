package com.home;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        int sameValTime = 0;
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == val) {
                sameValTime++;
                for (int j = 0; j < nums.length - i-1; j++) {
                    nums[i + j] = nums[i + j + 1];
                }
                i--;
                len--;
            }
            i++;
            soutNum(nums);
        }
        return nums.length - sameValTime;
    }

    public static int removeElementFast(int[] nums, int val) {
        int slow = 0, fast=1;
        int length = nums.length;
        while (fast < length) {
            if (val == nums[fast]) {
                slow+=1;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast=1;
        int length = nums.length;
        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                slow+=1;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    private static void soutNum(int[] nums) {
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
