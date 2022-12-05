package com.akikun.algorithm.base;

/**
 * 两种算斐波那契数列的方法
 *
 * 递归和迭代
 *
 * the two solutions of Fibonacci
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        int ans1, ans2;
        long start, end;

        int n = 45;

        start = System.currentTimeMillis();
        ans2 = test.iteration(n);
        end = System.currentTimeMillis();
        System.err.println("iteration answer: " + ans2 +", time: " + (end - start));

        // 如果想尝试递归方式，取消下面的注释
//        start = System.currentTimeMillis();
//        ans1 = test.recursion(n);
//        end = System.currentTimeMillis();
//        System.err.println("recursion answer: " + ans1 +", time: " + (end - start));

        int ans3 = test.dp(n);
        System.err.println("DP answer: " + ans3);
    }

    int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    int iteration(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        n -= 2;

        int a = 1, b = 1;
        int temp;
        for (int i = 0; i < n; ++i) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    int dp(int n) {
        if (n < 3) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
