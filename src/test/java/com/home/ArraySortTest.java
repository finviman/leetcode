package com.home;

import org.junit.jupiter.api.Test;

import java.util.Random;


/**
 * Created by liyang on 4/19/20.
 * liyang27@le.com;
 * only in letv.
 */
class ArraySortTest {

    @Test
    public void testBubble() {
        int n = 100_000;
        int[] testData = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = r.nextInt(n);
        }
        long time = System.currentTimeMillis();
        ArraySort.bubbleSort(testData);
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    public void testInsert() {
        int n = 100_000;
        int[] testData = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = r.nextInt(n);
        }
        long time = System.currentTimeMillis();
        ArraySort.insertSort(testData);
        System.out.println(System.currentTimeMillis()-time);
    }

    private void dumpArray(int[] data) {
        for (int item : data) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

}