package com.akikun.leetcode;



// 给你一个整数数组 nums 以及两个整数 lower 和 upper 。
// 求数组中，值位于范围 [lower, upper] （ lower 和 upper）之内的 区间和的个数 。
//
// 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//
//【示例】
// 输入：nums = [-2,5,-1], lower = -2, upper = 2
// 输出：3
// 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。


public class _00375_CountOfRangeSum {

    public static void main(String[] args) {

        _00375_CountOfRangeSum solution = new _00375_CountOfRangeSum();

        int[] nums = new int[]{4,5,6,1,-1,3,-4,-17,5,0};
//        int[] nums2 = new int[]{-2, 5, -1};

        int result = solution.countRangeSum(nums, -10, 10);
//        int result = solution.countRangeSum(nums2, -2, 2);

        System.out.println(result);

    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSums = new long[nums.length + 1];

        long preSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            preSum += nums[i];
            preSums[i + 1] = preSum;
        }

        return sum(preSums, 0, nums.length, lower, upper);
    }

    public int sum(long[] preSums, int L, int R, int lower, int upper) {
        if (L == R) {
            return 0;
        }
        int M = L + (R - L) / 2;

        int left = sum(preSums, L, M, lower, upper);
        int right = sum(preSums, M+1, R, lower, upper);
        int merge = merge(preSums, L, M, R, lower, upper);

        return left + right + merge;
    }

    public int merge(long[] preSums, int L, int M, int R, int lower, int upper) {
        if (L >= R) {
            return 0;
        }

        int cnt = 0;
        int left = M + 1;
        int right = M + 1;

        for (int i = L; i <= M; ++i) {
            while (left <= R && preSums[left] - preSums[i] < lower) {
                left++;
            }
            while (right <= R && preSums[right] - preSums[i] <= upper) {
                right++;
            }

            cnt += right - left;
        }

        long[] temp = new long[R - L + 1];
        left = L; right = M + 1;
        int idx = 0;
        while (left <= M || right <= R) {
            if (left > M) {
                temp[idx++] = preSums[right++];
                continue;
            }

            if (right > R) {
                temp[idx++] = preSums[left++];
                continue;
            }

            if (preSums[left] > preSums[right]) {
                temp[idx++] = preSums[right++];
            } else {
                temp[idx++] = preSums[left++];
            }
        }

        for (int i = L; i <= R; ++i) {
            preSums[i] = temp[i - L];
        }

        return cnt;
    }

}
