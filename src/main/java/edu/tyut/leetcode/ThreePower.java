package edu.tyut.leetcode;

public class ThreePower {
    public static void main(String[] args) {
        System.out.println(new ThreePower().isPowerOfThree(243));
    }

    public boolean isPowerOfThree(int n) {
        while(true) {
            if (n % 3 == 0) {
                n /= 3;
            }
            if (n == 1) {
                return true;
            }
        }
    }
}
