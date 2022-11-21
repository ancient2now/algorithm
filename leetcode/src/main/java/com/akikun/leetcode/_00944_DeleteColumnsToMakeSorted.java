package com.akikun.leetcode;

/**
 * @author 李俊秋(龙泽)
 */
public class _00944_DeleteColumnsToMakeSorted {

    public static void main(String[] args) {

        // Excepted: 5
//        String[] strs = {"cba", "daf", "ghi"};

        String[] strs = {"a", "b"};

        _00944_DeleteColumnsToMakeSorted test = new _00944_DeleteColumnsToMakeSorted();
        int result = test.minDeletionSize(strs);

        System.out.println(result);

    }

    public int minDeletionSize(String[] strs) {

        if (strs.length < 2) {
            return 0;
        }


        char[] lastCharArr = strs[0].toCharArray();

        boolean[] isDelete = new boolean[lastCharArr.length];

        for (int i = 1; i < strs.length; ++i) {
            char[] currCharArr = strs[i].toCharArray();

            for (int j = 0; j < isDelete.length; ++j) {
                if (!isDelete[j] && (currCharArr[j] - lastCharArr[j] < 0)) {
                    isDelete[j] = true;
                }
            }

            lastCharArr = currCharArr;
        }

        int cnt = 0;
        for (int i = 0; i <isDelete.length; ++i) {
            if (isDelete[i]) {
                cnt++;
            }
        }
        return cnt;

    }
}
