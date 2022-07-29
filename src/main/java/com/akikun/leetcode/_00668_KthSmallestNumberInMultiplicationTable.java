package com.akikun.leetcode;

/**
 * @author 李俊秋(龙泽)
 */
public class _00668_KthSmallestNumberInMultiplicationTable {

    public static void main(String[] args) {
        _00668_KthSmallestNumberInMultiplicationTable test = new _00668_KthSmallestNumberInMultiplicationTable();
        int result = test.findKthNumber(20, 60, 13);
    }


    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
