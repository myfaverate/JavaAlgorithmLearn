package edu.tyut.lanqiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WordAnalysis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String str = scan.next();
        int len = str.length();
        int[][] chars = new int[26][2];
        for (int i = 0; i < len; i++) {
            chars[str.charAt(i)-'a'][0]++;
        }
        for (int i = 0; i < 26; i++) {
            chars[i][1]=i;
        }
        Arrays.sort(chars, (o1, o2) -> {
            if (o1[0]==o2[0]){
                return o2[1]-o1[1];
            }else {
                return o1[0]-o2[0];
            }
        });

        System.out.println((char)(chars[25][1]+'a'));
        System.out.println(chars[25][0]);
        scan.close();
    }
}
