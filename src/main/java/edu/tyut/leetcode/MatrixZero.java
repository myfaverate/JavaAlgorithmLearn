package edu.tyut.leetcode;

import java.util.Arrays;

public class MatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 1, 1, 2},
                {1, 3, 1, 5},
        };
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        // 使用第一行列为临时数字
        // 保存原始临时数组的值
        int rowLen = matrix[0].length;
        int colLen = matrix.length;
        int[] rowArr = new int[rowLen];
        int[] colArr = new int[colLen];
        for (int i = 0; i < rowLen; i++) {
            rowArr[i] = matrix[0][i];
        }
        for (int i = 0; i < colLen; i++) {
            colArr[i] = matrix[i][0];
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }

        for (int i = 1; i < rowLen; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < colLen; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < colLen; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < rowLen; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            if (rowArr[i] == 0) {
                for (int j = 0; j < rowLen; j++) {
                    matrix[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < colLen; i++) {
            if (colArr[i] == 0) {
                for (int j = 0; j < colLen; j++) {
                    matrix[j][0] = 0;
                }
                break;
            }
        }
    }
}
