package edu.tyut.leetcode;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().increasingTriplet(new int[]{4,3,1,7}));
    }
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int left= 0;
        int right = 1;
        while (right<len){
            if (s.charAt(left)!=s.charAt(right)){
                max = Math.max(max,right-left+1);
                right++;
            }else {
                left++;
                right=left+1;
            }
        }
        return max;
    }
    public String longestPalindrome1(String s) {

        // 中心扩散法
        int len = s.length();
        int left = 0;
        int right = 0;
        String result = "";
        if(s.length()<2) return s;

        // 判断回文子串
        if(this.isSub(s)) return s;

        for (int i = 0; i < len; i++) {
            int j = i;
            while(j<len-1&&(s.charAt(i)==s.charAt(j+1))){
                j++;
            }
            String tmp = s.substring(i,j+1);
            if(tmp.length()>result.length()){
                result = tmp;
            }
        }
        for(int i=1;i<len-1;i++){ // "cbbbd"
            left=i;
            right=i;
            while (left>0&&right<len-1&&(s.charAt(left-1)==s.charAt(right+1))){ // left>0&&right<len-1&&
                left--;
                right++;
            }
            String tmp = s.substring(left,right+1);
            if(tmp.length()>result.length()){
                result = tmp;
            }
        }

        return result;
    }
    public boolean isSub(String str){
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            if (str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else {
                return  false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2) return s;

        int left;
        int right;
        String result = "";
        for (int i = 1; i < len-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                left=i;
                right=i+1;
                while (left>0&&right<len-1&&(s.charAt(left-1)==s.charAt(right+1))){ // left>0&&right<len-1&&
                    left--;
                    right++;
                }
                String tmp = s.substring(left,right+1);
                if(tmp.length()>result.length()){
                    result = tmp;
                }
            }
            if(s.charAt(i-1)==s.charAt(i)){
                left=i-1;
                right=i;
                while (left>0&&right<len-1&&(s.charAt(left-1)==s.charAt(right+1))){ // left>0&&right<len-1&&
                    left--;
                    right++;
                }
                String tmp = s.substring(left,right+1);
                if(tmp.length()>result.length()){
                    result = tmp;
                }
            }
            if(s.charAt(i-1)==s.charAt(i+1)){
                left=i-1;
                right=i+1;
                while (left>0&&right<len-1&&(s.charAt(left-1)==s.charAt(right+1))){ // left>0&&right<len-1&&
                    left--;
                    right++;
                }
                String tmp = s.substring(left,right+1);
                if(tmp.length()>result.length()){
                    result = tmp;
                }
            }
        }
        return result;
    }
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) { // 4 8 1 7
            if (small>=nums[i]){
                small=nums[i];
            }else if(mid>=nums[i]){
                mid=nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}
