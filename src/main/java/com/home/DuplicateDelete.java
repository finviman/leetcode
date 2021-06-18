package com.home;

public class DuplicateDelete {
    public static void main(String[] args) {
        int[] nums ={1,1,2,2,3,3,4};
        int resultLength = removeDuplicates(nums);
        for (int i=0;i<resultLength;i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[cur + 1] = nums[i];
                cur++;
            }
        }
        return cur+1;
    }

}
