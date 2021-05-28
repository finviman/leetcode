package com.home;

/**
 * Created by liyang on 4/12/20.
 * liyang27@le.com;
 * only in letv.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char iPosition = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != iPosition){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
