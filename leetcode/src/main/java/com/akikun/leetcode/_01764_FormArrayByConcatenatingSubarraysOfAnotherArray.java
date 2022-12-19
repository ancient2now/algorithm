package com.akikun.leetcode;

import com.akikun.algorithm.common.ArrayUtils;

/**
 * @author 李俊秋(龙泽)
 */
public class _01764_FormArrayByConcatenatingSubarraysOfAnotherArray {

    public static void main(String[] args) {
        _01764_FormArrayByConcatenatingSubarraysOfAnotherArray
            solution = new _01764_FormArrayByConcatenatingSubarraysOfAnotherArray();

        int[][] groups = new int[][]{{1,2,3},{3,4}};
        int[] nums = ArrayUtils.readArray("[7,7,1,2,3,4,7,7]");
        solution.canChoose(groups, nums);
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int start = 0, g = 0;
        while (g < groups.length && start < nums.length) {
            if (check(nums, groups[g], start)) {
                start += groups[g].length;
                g++;
            } else {
                start++;
            }
        }

        return g == groups.length;

    }

    private boolean check(int[] nums, int[] group, int start) {
        if ((start + group.length) > nums.length) {
            return false;
        }
        for (int i = 0; i < group.length; ++i) {
            if (nums[i + start] != group[i]) {
                return false;
            }
        }
        return true;
    }

}
