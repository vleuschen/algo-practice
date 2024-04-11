package com.akm.algo.mayi;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个整数目标值 target，
请你在该数组中找出 和为目标值 target
的那两个整数，并返回它们的数组下标。
 */
public class TwoSum {

    /**
     * 暴力穷举
     */
    public static int[] twoNum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    /**
     * 减少扫描的次数
     */
    public static int[] twoSum2(int[] nums, int target) {

        //引入map, key为元素值，value为下标
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            Integer resultIndex = map.get(num);
            if (null != resultIndex) {
                result[0] = i;
                result[1] = resultIndex;
                return result;
            }else {
                map.put(nums[i], i);
            }

        }

        return result;
    }



    public static void main(String[] args) {

        int[] result1 = twoNum(new int[]{3,3}, 6);
        System.out.println(result1[0] + "" + result1[1] );

    }
}


