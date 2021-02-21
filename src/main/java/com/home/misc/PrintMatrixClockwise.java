package com.home.misc;

/**
 * Created by liyang70 on 12/26/20.
 * liyang70@meituan.com;
 */
public class PrintMatrixClockwise {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = i+j;
            }
        }
        System.out.println("===========original matrix==========");
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========print matrix==========");

    }
}
