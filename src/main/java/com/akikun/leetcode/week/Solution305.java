package com.akikun.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/weekly-contest-305
 */
public class Solution305 {

    public static void main(String[] args) {
        Solution305 solution = new Solution305();

        int[] nums = {1,2,3};
        solution.validPartition(nums);
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i <=len; ++i ) {
            for (int j = i + 1; j <= len; ++j) {
                if (nums[j] - nums[i] != diff) {
                    continue;
                }
                for (int k = j + 1; k <= len; ++k) {
                    if (nums[k] - nums[j] == diff) {
                        res ++;
                    }
                }
            }
        }

        return res;

    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        Set<Integer> restrictSet = new HashSet<>();
        for (int i : restricted) {
            restrictSet.add(i);
        }



        int[] from = new int[n];
        for (int i = 0; i <n; ++i) {
            from[i] = i;
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges.length; ++i) {
            int[] side = edges[i];
            map.get(side[0]).add(side[1]);
            map.get(side[1]).add(side[0]);
        }

        int[] findMap = new int[n];
        Queue<Integer> nextFind = new LinkedList<>();
        nextFind.add(0);

        while(!nextFind.isEmpty()) {
            Integer index = nextFind.poll();
            if (findMap[index] == 1 || restrictSet.contains(index)) {
                continue;
            }

            findMap[index] = 1;
            Set<Integer> nexts = map.get(index);
            nextFind.addAll(nexts);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += findMap[i];
        }
        return res;


    }

    public boolean validPartition(int[] nums) {

        int[] map = new int[nums.length + 1];
        map[0] = 1;

        for (int i = 1; i < nums.length; ++i ) {
            boolean aIsOk = map[i - 1] == 1 && nums[i] == nums[i - 1];

            boolean bIsOk = (i - 2) >= 0 && map[i - 2] == 1 && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]);

            boolean cIsOk = (i - 2) >= 0 && map[i - 2] == 1 && (nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1);

            if (aIsOk || bIsOk || cIsOk) {
                map[i + 1] = 1;
            }
        }
        return map[nums.length] == 1;
    }

    public int longestIdealString(String s, int k) {

        int[] count = new int[26];

        int max = 0;
        for (char c : s.toCharArray()) {
            int left = Math.max('a', c - k) - 'a';
            int right = Math.min('z', c + k) - 'a';

            for (int i = left; i <= right; i++) {
                count[c - 'a'] = Math.max(count[c - 'a'], count[i]);
            }
            max = Math.max(max, ++count[c - 'a']);
        }
        return max;

    }


}
