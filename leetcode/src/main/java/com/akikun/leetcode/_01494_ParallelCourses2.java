package com.akikun.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 李俊秋(龙泽)
 */
public class _01494_ParallelCourses2 {

    public static void main(String[] args) {
        // 4
        // [[2,1],[3,1],[1,4]]
        // 2
        // Except: 3

        _01494_ParallelCourses2 solution = new _01494_ParallelCourses2();
        int ans = solution.minNumberOfSemesters(4, new int[][] {{2, 1}, {3, 1}, {1, 4}}, 2);
        System.out.println(ans);
    }


    public int minNumberOfSemesters(int m, int[][] relations, int k) {
        int n = m + 1;
        int[][] graph = new int[n][n];
        int[] in = new int[n];
        for (int i = 0; i < relations.length; ++i) {
            int f = relations[i][0], t = relations[i][1];
            graph[f][t] = 1;
            in[t]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; ++i) {
            if (in[i] == 0) {
                queue.addLast(i);
            }
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            cnt++;
            int can = Math.min(queue.size(), k);
            while(can-- > 0) {
                int f = queue.pollFirst();
                for (int i = 1; i < n; ++i) {
                    if (graph[f][i] == 1) {
                        graph[f][i] = 0;
                        in[i]--;
                        if (in[i] == 0) {
                            queue.addLast(i);
                        }
                    }
                }
            }
        }

        return cnt;

    }
}
