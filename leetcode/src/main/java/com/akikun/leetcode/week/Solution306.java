package com.akikun.leetcode.week;

import java.util.Arrays;

/**
 * @author 李俊秋(龙泽)
 */
public class Solution306 {

    public static void main(String[] args) {
        Solution306 solution = new Solution306();
        int res = solution.countSpecialNumbers(420);
        System.out.println(res);
    }

    int[][] map;
    char[] chars;
    public int countSpecialNumbers(int n) {
        String s = String.valueOf(n);
        chars = s.toCharArray();
        map = new int[chars.length][1 << 10];

        for (int i = 0; i < chars.length; ++i) {
            Arrays.fill(map[i], -1);
        }

        return f (0, 0, true, false);
    }

    private int f (int i, int mask, boolean isLimit, boolean isNum) {

        if (i == chars.length) {
            return isNum ? 1 : 0;
        }


        // TODO ??? 没有十分清楚这边区分判断isLimit 和 isSum 的本质，没有这个，结果不正确
        if (!isLimit && isNum && map[i][mask] > 0) {
            return map[i][mask];
        }

        int res = 0;
        if (!isNum) {
            res = f(i+1, mask, false, false);
        }

        int begin = isNum ? 0 : 1;
        int end = isLimit ? chars[i] - '0' : 9;
        for (int j = begin; j <= end; ++j) {
            if ((mask & (1 << j)) == 0) {
                int nextMask = mask | (1 << j);
                boolean nextLimit = isLimit && (chars[i] - '0' == j);
                res += f(i + 1, nextMask, nextLimit, true);
            }
        }

        if (!isLimit && isNum) {
            map[i][mask] = res;
        }


        return res;

    }

    public String smallestNumber(String pattern) {
        return null;

    }

}
