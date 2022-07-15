package edu.tyut.TopCoder;

import java.util.Arrays;

public class Caketown {
    public int howManyBites(int[] cakeSize, int numFriends){
        quickSort(0, cakeSize.length - 1, cakeSize);
        System.out.println(Arrays.toString(cakeSize));
        int result = 0;
        for (int i = 0; i < cakeSize.length; i+=(numFriends+1)) {
            result+=cakeSize[i];
        }
        return result;
    }
    public void quickSort(int left, int right, int[] array) {
        // 改进
        int l = left;
        int r = right;
        int tmp = array[left];
        while (l < r) {
            while (l < r&&array[r] <= tmp) {
                r--;
            }
            array[l]=array[r];
            while (l < r&&array[l] >= tmp) {
                l++;
            }
            array[r]=array[l];
        }
        array[r]=tmp;
        l++;
        r--;
        if (left<r){
            quickSort(left,r,array);
        }
        if (right>l){
            quickSort(l,right,array);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Caketown().howManyBites(new int[]{6, 7, 9, 6, 4}, 2));
    }
}
