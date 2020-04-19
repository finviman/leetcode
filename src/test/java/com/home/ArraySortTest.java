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
        int[] testData = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            testData[i] = r.nextInt(100);
        }
        dumpArray(testData);
        ArraySort.bubbleSort(testData);
        dumpArray(testData);
    }

    @Test
    public void testInsert() {
        int[] testData = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            testData[i] = r.nextInt(100);
        }
        dumpArray(testData);
        ArraySort.insertSort(testData);
    }

    private void dumpArray(int[] data) {
        for (int item : data) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

}