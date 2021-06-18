package com.home;

public class FindRepeatNumber{
    public static void main(String[] args){
        int[] nums = {6, 5, 1, 4, 2, 5, 3};
        int re = findRepeatNumber(nums);
        System.out.println(re);
    }

    private static int findRepeatNumber(int[] nums){
        int[] help = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==help[nums[i]]){
                return nums[i];
            }else{
                help[nums[i]] = nums[i];
            }
        }
        return 0;
    }
}
