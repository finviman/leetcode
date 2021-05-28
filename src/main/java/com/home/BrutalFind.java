package com.home;
/**
 * Created by liyang on 4/11/20.
 * liyang27@le.com;
 * only in letv.
 */
public class BrutalFind {
    public static int brutalFind(String main, String mod){
        if (main.length()<mod.length()) {
           return -1; 
        }
        char[] mainChars = main.toCharArray();
        char[] modChars = mod.toCharArray();
        int matchLength = 0;
        int i;
        for (i = 0; i < mainChars.length; i++)  {
            for (int j = 0; j < modChars.length; j++)  {
                if(i+j<mainChars.length && mainChars[i+j] == modChars[j]){
                    matchLength++;
                }else{
                    matchLength = 0;
                    break;
                }
            }
            if(matchLength == modChars.length){
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        System.out.println(brutalFind("aaaaab","ab"));
    }
}
