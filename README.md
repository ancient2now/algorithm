# 数据结构与算法

按照我自己学习时的理解难易，将算法分为初级、中级、高级这几个难度。

学习老师：左神。

`初级（简单、低中等）：` 稍微学习，比如听一遍就会了，最多学习不超过三遍；主要是那种需要巧妙的方法，不学习不会，一学醍醐灌顶  
`中级（高中等、低困难）：` 需要多理解几遍，需要多花点时间理解，琢磨  
`高级（高困难）：` 就是那种难的、复杂的算法 

`【例】`代表的是练习的算法题，算法题描述写在java文件的注释里

### 初级算法

* 迭代和递归
* 异或
* 链表
  - 快慢指针
* [排序](algorithm/src/main/java/com/akikun/algorithm/sort)
  - 冒泡排序
  - 插入排序
* 二叉树
  - 先序、中序、后序遍历 
  - 判断二叉树是否是***树
* 前缀树

### 中级算法

* 递归
  - 【例】汉诺塔
  - 【例】打印字符串的所有子字符串
  - 【例】打印字符串的排列组合
  - 【例】不使用额外空间，反转一个栈
  
* [排序](algorithm/src/main/java/com/akikun/algorithm/sort)
    - [基数排序](algorithm/src/main/java/com/akikun/algorithm/sort/RadixSort.java)
    - [堆排序](algorithm/src/main/java/com/akikun/algorithm/sort/HeapSort.java)
    - [快速排序](algorithm/src/main/java/com/akikun/algorithm/sort/QuickSort.java)
    - 合并排序
  
* 图
  - 最小生成树（无向图的最短路径算法）
    - Kruskal算法
    - Prim算法
  - 有向图的最短路径算法
    - Dijkstra算法（迪杰斯特拉）
    - floyd算法
  
* 并查集
  
* 从暴力递归到动态规划（递归 -> 记忆化搜索 -> 真正的动态规划）   
  *记忆化搜索 = 从顶向下的动态规划*
  - 【例】机器人从原始位置到目标位置移动路径问题
  - 【例】甲、乙两个玩家拿数字博弈问题
  - 【例】经典的背包问题

### 高级算法

### 其他、冷门、技巧

* 置换环


# 收藏并推荐的算法题

强烈推荐的算法题，或者是具有启发性的算法题；从容易到难排序

| No. | Problems | Solutions | Tag |
| ------ | ------ | ------ | ------ |
| 32  | [Longest Valid Parentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00032_LongestValidParentheses.java) | DP, Stack |


# leetcode

#### 推荐

| No. | Problems | Solutions | Tag |
| ------ | ------ | ------ | ------ |
| 32  | [Longest Valid Parentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00032_LongestValidParentheses.java) | DP, Stack |

#### 周赛 (weekly-content)
| No. |  Solutions | Completion Date |
| ------ | ------ | ------ |
| [196](https://leetcode-cn.com/contest/weekly-contest-196) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00108_ConvertSortedArrayToBinarySearchTree.java) | 2020.07.05 |  
 
#### 刷题记录

| No. | Problems | Solutions | Completion Date |
| ------ | ------ | ------ | ------ |
| 329 | [Longest Increasing Path in a Matrix](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00329_LongestIncreasingPathInAMatrix.java) | 2020.07.26 |
| 16 | [最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00036_3SumClosest.java) | 2020.07.22 |
| 856 | [Score of Parentheses](https://leetcode-cn.com/problems/score-of-parentheses/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00865_ScoreOfParentheses.java) | 2020.07.21 |
| 95 | [Unique Binary Search Trees II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00095_UniqueBinarySearchTreesII.java) | 2020.07.21 |
| 785 | [Is Graph Bipartite?](https://leetcode-cn.com/problems/is-graph-bipartite/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00785_IsGraphBipartite.java) | 2020.07.16 |
| 96 | [Unique Binary Search Trees](https://leetcode-cn.com/problems/unique-binary-search-trees/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00096_UniqueBinarySearchTrees.java) | 2020.07.15 |
| 174 | [Dungeon Game](https://leetcode-cn.com/problems/dungeon-game/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00174_DungeonGame.java) | 2020.07.12 |
| 309 | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00309_BestTimetoBuyandSellStockwithCooldown.java) | 2020.07.10 |
| 120 | [Triangle](https://leetcode-cn.com/problems/triangle/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00120_Triangle.java) | 2020.07.06 |
| 142 | [Linked List Cycle II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00142_LinkedListCycleII.java) | 2020.07.06 |
| 63 | [Unique Paths II](https://leetcode-cn.com/problems/unique-paths-ii/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00063_UniquePathsII.java) | 2020.07.06 |
| 32  | [Longest Valid Parentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00032_LongestValidParentheses.java) | 2020.07.04 |
| 108 | [Convert Sorted Array to Binary Search Tree](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00108_ConvertSortedArrayToBinarySearchTree.java) | 2020.07.03 |
| 378 | [Kth Smallest Element in a Sorted Matrix](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00378_KthSmallestElementInASortedMatrix.java) | 2020.07.02 |
| 718 | [Maximum Length of Repeated Subarray](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00718_MaximumLengthOfRepeatedSubarray.java) | 2020.07.01 |
| 168 | [Excel Sheet Column Title](https://leetcode-cn.com/problems/excel-sheet-column-title/submissions/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00168_ExcelSheetColumnTitle.java) | 2020.06.30 |
| 1139 | [Largest 1-Bordered Square](https://leetcode-cn.com/problems/largest-1-bordered-square/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_01139_Largest1_BorderedSquare.java) | 2020.06.29 |
| 215 | [Kth Largest Element in an Array](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00215_KthLargestElementInAnArray.java) | 2020.06.29 |
| 209 | [Minimum Size Subarray Sum](https://leetcode-cn.com/problems/minimum-size-subarray-sum/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00209_MinimumSizeSubarraySum.java) | 2020.06.28 |
| 41  | [First Missing Positive](https://leetcode-cn.com/problems/first-missing-positive/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00041_FirstMissingPositive.java) | 2020.06.27 |
| 139 | [Word Break](https://leetcode-cn.com/problems/word-break/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00139_WordBreak.java) | 2020.06.25 |
| 67  | [Add Binary](https://leetcode-cn.com/problems/add-binary/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00067_AddBinary.java) | 2020.06.23 |
| 889 | [根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00889_ConstructBinaryTreeFromPrePost.java) | 2020.06.22 |
| 289 | [Game of Life](https://leetcode-cn.com/problems/game-of-life/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00289_GameOfLife.java) | 2020.05.20 |
| 125 | [Valid Palindrome](https://leetcode-cn.com/problems/valid-palindrome/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_00125_ValidPalindrome.java) | 2020.06.19 |
| 1190 | [Reverse Substrings Between Each Pair of Parentheses](https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/) | [Java](leetcode/src/main/java/com/akikun/leetcode/_01190_ReverseSubstrings.java) | 2021.05.27 |

#### 面试题部分

| No. | Problems | Solutions | Completion Date |
| ------ | ------ | ------ | ------ |
| 17.13 | [Re-Space LCCI](https://leetcode-cn.com/problems/re-space-lcci/) | [Java](leetcode/src/main/java/com/akikun/leetcode/interview/_17_13_ReSpaceLCCI.java) | 2020.07.09 |
| 16.11 | [Diving Board LCCI](https://leetcode-cn.com/problems/diving-board-lcci/) | [Java](leetcode/src/main/java/com/akikun/leetcode/interview/_16_11_DivingBoardLCCI.java) | 2020.07.08 |
| 02.01 | [Remove Duplicate Node](https://leetcode-cn.com/problems/remove-duplicate-node-lcci/) | [Java](leetcode/src/main/java/com/akikun/leetcode/interview/_02_01_RemoveDuplicateNode.java) | 2020.06.26 |

#### 剑指Offer

| No. | Problems | Solutions | Completion Date |
| ------ | ------ | ------ | ------ |
| 09 | [用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) | [Java](leetcode/src/main/java/com/akikun/leetcode/offer/CQueue.java) | 2020.06.30 | 

#### 常用算法练习

[quick sort](leetcode/src/main/java/com/akikun/leetcode/algorithm/QuickSort.java)
[Recursion && Iteration](leetcode/src/main/java/com/akikun/leetcode/algorithm/Fibonacci.java)

## 字节跳动

###### 数组与排序

| Problems | Solutions | Completion Date |
| ------ | ------ | ------ |
| [岛屿的最大面积](https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/) | [Java](leetcode/src/main/java/com/akikun/leetcode/bytedance/MaxAreaOfIsland.java) | 2020.06.30 |

# 牛客网

