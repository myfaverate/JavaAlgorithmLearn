package edu.tyut.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeNumSum {
    public static void main(String[] args) {
        System.out.println(new ThreeNumSum().threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // if(nums==null||nums.length<3) return null;
        var list = new ArrayList<Integer>();
        list.add(0, 0);
        list.add(1, 0);
        list.add(2, 0);
        var result = new ArrayList<List<Integer>>();
        // 对数组排序
        Arrays.parallelSort(nums);
        int len = nums.length;
        int left;
        int right;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // [[-2, -1, 3], [-2, 0, 2]]
                continue;
            }
            if (nums[i] > 0) break;
            left = i + 1;
            right = len - 1;
            while (left < right) {
                if ((nums[i] + nums[left] + nums[right] == 0)) {
                    list.set(0, nums[i]);
                    list.set(1, nums[left]);
                    list.set(2, nums[right]);
                    result.add(new ArrayList<>(list));
                }
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    left++;
                    right--;
                }
            }
        }
        List<List<Integer>> result1 = result.stream().distinct().collect(Collectors.toList());
        return result1;
    }
}
