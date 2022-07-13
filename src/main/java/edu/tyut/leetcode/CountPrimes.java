package edu.tyut.leetcode;

import java.util.ArrayList;

public class CountPrimes {
    public int countPrimes1(int n) {
        if (n == 0 || n == 1 || n == 2) return 0;
        var list = new ArrayList<Integer>();

        for (int i = 2; i < n; i++) {
            list.add(i);
        }

        int j = 0;
        int sq = list.get(j);
        while (Math.pow(sq, 2) < n) {
            for (int i = 2; i < list.size(); i++) { // i=i*sq
                list.remove((Integer) (i * sq));
            }
            j++;
            sq = list.get(j);
        }
        System.out.println(list);
        return list.size();
    }

    public int countPrimes(int n) {
        boolean[] booleans = new boolean[n];
        int result = 0;
        int k = 2; // 筛子
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(j%2==0&&j!=k) booleans[j]=true;
            }
            for (int j = 1; j < n; j++) {
                if(j>k&& !booleans[j]) {
                    k=j;
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(499979)); // 499979 41537
    }
}

class assf {
    public static void main(String[] args) {
        int aa[] = new int[499979];
        aa[2] = 0;
        int k = 2, tt = 0;
        while (tt < 499979) {
            for (int i = 1; i < aa.length; i++){ //将不是素数的数筛出
                if (i % k == 0 && i != k) aa[i] = 1;
            }
            for (int i = 1; i < aa.length; i++){ //将筛选后的第一个数当做新的筛子
                if (i > k && aa[i] == 0) {
                    k = i;
                    break;
                }
            }
            tt++;
        }
        for (int i = 1; i < aa.length; i++)
            if (aa[i] == 0) System.out.printf("%d ", i);
    }
}