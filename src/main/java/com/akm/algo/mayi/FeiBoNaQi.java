package com.akm.algo.mayi;

/**
 * 实现斐波那契数列
 */
public class FeiBoNaQi {

    public static int feiBoNaQi(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return (feiBoNaQi(n - 1) + feiBoNaQi(n - 2)) % 1000000007;
    }

    public static int feiBoNaQi2(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 ) {
            return 1;
        }

        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            int result = pre + prePre;
            prePre = pre;
            pre = result % 1000000007;
        }

        return pre;
    }

    public static void main(String[] args) {

        System.out.println(feiBoNaQi(45));
        System.out.println(feiBoNaQi2(45));

    }
}
