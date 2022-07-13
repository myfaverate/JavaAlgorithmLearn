package edu.tyut.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {
    public static void main(String[] args) {
        System.out.println(new ThreeNumSum().threeSum(new int[]{3,0,-2,-1,1,2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // if(nums==null||nums.length<3) return null;
        var list = new ArrayList<Integer>();
        list.add(0,0);list.add(1,0);list.add(2,0);
        var result = new ArrayList<List<Integer>>();
        // 对数组排序
        Arrays.parallelSort(nums);
        int len = nums.length;
        int left = 1;
        int right = len-1;
        for(int i=0;i<len-2;i++){
            if(i>0&&nums[i]==nums[i-1]){ // [[-2, -1, 3], [-2, 0, 2]]
                continue;
            }
            left=i+1;
            right=len-1;
            while(left<right){
                if((nums[i]+nums[left]+nums[right]==0)){
                    list.set(0,nums[i]);
                    list.set(1,nums[left]);
                    list.set(2,nums[right]);
                    result.add(new ArrayList<>(list));
                }
                left++;
                right--;
            }

        }
        return result;
    }
}
