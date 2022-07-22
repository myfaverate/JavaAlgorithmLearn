package edu.tyut.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class ConfusingNumber {
    public static boolean confusingNumber1(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        var hash = new HashMap<Character,Character>();
        hash.put('0','0');
        hash.put('1','1');
        hash.put('6','9');
        hash.put('8','8');
        hash.put('9','6');
//        for(int i=0;i<len;i++){
//            if(!hash.containsKey(str.charAt(i))) return false;
//        }
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        for(int i=0;i<len;i++){
            if(!hash.containsKey(builder.charAt(i))) return false;
            builder.setCharAt(i,hash.get(builder.charAt(i)));
        }
        if(n==Integer.parseInt(builder.toString())){
            return false;
        }
        return true;
    }



    public static boolean confusingNumber(int n) {
        // 使用数字
        int tmp=n;
        int r = 0;
        int result = 0;
        if (n==0) return false;
        while (tmp!=0){
            r=tmp%10;
            if (r==6){
                r=9;
            }else if (r==9){
                r=6;
            }
            tmp=tmp/10;
            // 0 1 6 8 9
            if (r==2||r==3||r==4||r==5||r==7){
                return false;
            }else {
                result=result*10+r;
            }
            if (result==n){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(a+b);
    }
}
/**
#include<stdio.h>
int main()
{
	printf("**************************\n");
	printf("dotcpp.com\n");
	printf("**************************\n");
	printf("%d",~(-1));
    // ~取反
	    1的原码         0000 00001
	    1取反之后：补码 1111 11110
	    1的反码：       1111 11101
	    1的原码：       1000 00010

	    -1的原码 1000 00001
	    -1的反码 1111 11110
	    -1的补码 1111 11111
	    -1取反   0000 00000

	return 0;
            }
*/