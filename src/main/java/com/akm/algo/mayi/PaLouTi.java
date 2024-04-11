package com.akm.algo.mayi;

import java.util.HashMap;
import java.util.Map;

public class PaLouTi {

    private static Map<Integer, Integer> stairsMap = new HashMap<>();

    //这个方法容易超时
    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * 可利用map存放已经求解过的值
     *
     * @param args
     */


    public static int climbStairs2(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (null != stairsMap.get(n)) {
            return stairsMap.get(n);
        } else {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            stairsMap.put(n, result);
            return result;
        }
    }

    /**
     * 利用循环求解
     *
     * @param args
     */
    public static int climbStairs3(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n ; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }

        return result;
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        System.out.print(climbStairs(30) + ": ");
        long l2 = System.currentTimeMillis();
        System.out.println((l2 - l1)+"ms");
        long l3 = System.currentTimeMillis();
        System.out.print(climbStairs2(30) + ": ");
        long l4 = System.currentTimeMillis();
        System.out.println((l4 - l3) + "ms");

        System.out.println(climbStairs3(30));
    }
}
