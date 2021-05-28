package com.home;

/**
 */
public class ArraySort {

    public static void bubbleSort(int[] data) {
        int n = data.length;
        for (int j = n; j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (data[i] > data[i + 1]) {
                    data[i] = data[i] ^ data[i + 1];
                    data[i + 1] = data[i] ^ data[i + 1];
                    data[i] = data[i] ^ data[i + 1];
                }
            }
        }
    }

    public static void insertSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int value = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                    data[j] = value;
                }
            }
        }
    }

    public static void mergeSort(int[] data) {
        int n = data.length;
        mergeSubArray(data, 0, n - 1);
    }

    private static int[] mergeSubArray(int[] data, int from, int to) {
        int middle = (to - from) / 2;
        if (middle - from == 0) {
            return new int[data[middle]];
        } else {
            int[] a = mergeSubArray(data, from, (from + to) / 2);
            int[] b = mergeSubArray(data, (from + to) / 2 + 1, to);
            int[] thisMergeRes = new int[to - from];
            int i = 0, j = 0;
            if (a[i] <= b[j]) {
                thisMergeRes[i + j] = a[i];
                i++;
            } else {
                thisMergeRes[i + j] = b[j];
                j++;
            }
            return thisMergeRes;
        }
    }

    private static void dumpArray(int[] data) {
        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 15, 33 };

        int i = 0;
        data[i] = data[i] ^ data[i + 1];
        data[i + 1] = data[i] ^ data[i + 1];
        data[i] = data[i] ^ data[i + 1];
        System.out.println(data[i] + "   " + data[i + 1]);
    }

}
