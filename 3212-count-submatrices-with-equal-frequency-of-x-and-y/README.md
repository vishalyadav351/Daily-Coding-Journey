# 3212. Count Submatrices With Equal Frequency of X and Y

[![LeetCode - Medium](https://img.shields.io/badge/LeetCode-Medium-orange?style=for-the-badge&logo=leetcode)](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)
[![Category - Matrix](https://img.shields.io/badge/Category-Matrix-blue?style=for-the-badge)](https://leetcode.com/tag/matrix/)
[![Category - PrefixSum](https://img.shields.io/badge/Category-PrefixSum-green?style=for-the-badge)](https://leetcode.com/tag/prefix-sum/)

## 📖 Overview
This repository implements a highly optimized *linear-time solution* for calculating submatrices starting at the origin (0,0) that satisfy specific frequency constraints. The solution leverages *2D Prefix Sums* to achieve optimal performance.

---

## 🎯 Problem Statement
Given a 2D character matrix grid, count the number of submatrices starting from grid[0][0] that satisfy:
1.  *Equal Frequency:* $\text{count}('X') == \text{count}('Y')$
2.  *Existence:* $\text{count}('X') \geq 1$

---

## 💡 Engineering Intuition & Design

### 1. The Brute Force Limitation
A naive approach would involve iterating through all possible bottom-right corners $(r, c)$ and then scanning the entire submatrix to count characters. 
* *Time Complexity:* $O(M^2 \times N^2)$ or $O(M \times N \times \min(M, N))$.
* *Verdict:* Too slow for a grid size of $1000 \times 1000$.

### 2. Optimized 2D Prefix Sum (The Google Way)
To achieve $O(1)$ lookup for character counts in any submatrix starting from $(0,0)$, we precompute two 2D arrays: countX and countY.

The recurrence relation used to fill the prefix sum matrix is based on the *Inclusion-Exclusion Principle*:
$$\text{PrefixSum}[i][j] = \text{Current} + \text{PrefixSum}[i-1][j] + \text{PrefixSum}[i][j-1] - \text{PrefixSum}[i-1][j-1]$$

### 3. Algorithm Steps
1.  Initialize two 2D arrays of size $(M+1) \times (N+1)$ to handle boundary conditions gracefully.
2.  Traverse the grid once.
3.  For each cell $(i, j)$, update the cumulative count of 'X' and 'Y'.
4.  Immediately validate the conditions: X == Y and X > 0.
5.  Increment the global counter if conditions are met.

---

## 🚀 Performance Analysis

| Metric | Complexity | Rationale |
| :--- | :--- | :--- |
| *Time Complexity* | $O(M \times N)$ | Each cell is processed exactly once in a single pass. |
| *Space Complexity* | $O(M \times N)$ | Two auxiliary prefix sum matrices are used to store state. |

---

## 💻 Technical Implementation (Java)

```java
/**
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] pX = new int[m + 1][n + 1];
        int[][] pY = new int[m + 1][n + 1];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pX[i + 1][j + 1] = pX[i][j + 1] + pX[i + 1][j] - pX[i][j] + (grid[i][j] == 'X' ? 1 : 0);
                pY[i + 1][j + 1] = pY[i][j + 1] + pY[i + 1][j] - pY[i][j] + (grid[i][j] == 'Y' ? 1 : 0);

                if (pX[i + 1][j + 1] == pY[i + 1][j + 1] && pX[i + 1][j + 1] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
