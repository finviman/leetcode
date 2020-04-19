package com.home;

/**
 * Hello world!
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubString {

    public static void main( String[] args ) {
        System.out.println("final result "+new LongestSubString().lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {

        int maxLength=0;
        char[] array = s.toCharArray();
        int length = s.length();
        for(int i=0;i<length;i++) {
            int currentPhaseLength=0;
            for(int j=i+1;j<length;j++) {
                if (isContain(array[j],array, i, j)) {
                    break;
                }else{
                    currentPhaseLength++;
                }
            }
            if (currentPhaseLength+1>=maxLength) {
                maxLength=currentPhaseLength+1;
            }
        }
        return maxLength;
    }

    private boolean isContain(char c, char[] array,int start,int end) {
        for(int i=start;i<end;i++) {
            if (c==array[i]) {
                return true;
            }
        }
        return false;
    }
}
