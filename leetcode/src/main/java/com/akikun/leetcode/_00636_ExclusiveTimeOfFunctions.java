package com.akikun.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _00636_ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        String[] logs = new String[]{"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
        int n = 2;

        _00636_ExclusiveTimeOfFunctions solution = new _00636_ExclusiveTimeOfFunctions();
        int[] res = solution.exclusiveTime(n, Arrays.asList(logs));
        System.out.println(Arrays.toString(res));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        String start = "start";
        String end = "end";

        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        int len = logs.size();

        int[] index = new int[len];
        String[] op = new String[len];
        int[] timestamp = new int[len];


        for (int i = 0; i <len; ++i) {
            String log = logs.get(i);
            String[] split = log.split(":");

            index[i] = Integer.parseInt(split[0]);
            op[i] = split[1];
            timestamp[i] = Integer.parseInt(split[2]);
        }

        for (int i  = 0; i < len; ++i) {
            if (start.equals(op[i])) {
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    res[peek[0]] += timestamp[i] - peek[1];
                }

                stack.push(new int[]{index[i], timestamp[i]});
            }

            if (end.equals(op[i])) {
                int[] pop = stack.pop();
                res[index[i]] += timestamp[i] - pop[1] + 1;
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    peek[1] = timestamp[i] + 1;
                }
            }
        }

        return res;

    }

}
