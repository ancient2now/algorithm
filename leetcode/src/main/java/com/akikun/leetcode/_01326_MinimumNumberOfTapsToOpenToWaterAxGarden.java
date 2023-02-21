package com.akikun.leetcode;

import com.akikun.algorithm.common.ArrayUtils;
import java.util.Arrays;

/**
 * @author 李俊秋(龙泽)
 */
public class _01326_MinimumNumberOfTapsToOpenToWaterAxGarden {

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = ArrayUtils.readArray("[3,4,1,1,0,0]");
        int target = 1;

        _01326_MinimumNumberOfTapsToOpenToWaterAxGarden solution =
            new _01326_MinimumNumberOfTapsToOpenToWaterAxGarden();
        int result = solution.minTaps(n, ranges);
        System.out.println(result);
    }

    public int minTaps(int n, int[] ranges) {
        int[][] water = new int[ranges.length][2];
        for (int i = 0; i < ranges.length; ++i) {
            water[i][0] = i - ranges[i];
            water[i][1] = i + ranges[i];
        }

        Arrays.sort(water, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] w : water) {
            int start = Math.max(0, w[0]);
            int end = Math.min(n, w[1]);
            if (dp[start] == Integer.MAX_VALUE) {
                return -1;
            }

            for (int i = start; i <= end; ++i) {
                dp[i] = Math.min(dp[start] + 1, dp[i]);
            }

        }

        return dp[n];
    }
}
