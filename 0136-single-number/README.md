# 🚀 Single Number - Optimal Bit Manipulation Solution

## 📌 Problem Overview
Given a *non-empty* array of integers nums, every element appears twice except for one unique element. The objective is to identify this unique value while adhering to strict performance constraints.

### 🎯 Engineering Constraints
* *Time Complexity:* $O(n)$ (Linear Time)
* *Space Complexity:* $O(1)$ (Constant Extra Space)
* *Methodology:* Bitwise XOR Manipulation

---

## 📊 Technical Execution Summary

| Feature | Details |
| :--- | :--- |
| *Algorithm* | *Bitwise XOR ($\oplus$) Manipulation* |
| *Primary Logic* | Utilizing the property $x \oplus x = 0$ to neutralize duplicates. |
| *Execution Path* | Single pass through the input array. |
| *Memory Footprint*| Zero auxiliary data structures (No HashMaps/Sets). |
| *Optimization* | Hardware-level bit processing for maximum speed. |

---

## 🧠 Core Engineering Logic
To achieve the $O(1)$ space requirement, we leverage the mathematical properties of the *XOR* operator:

1. *Identity Property:* $A \oplus 0 = A$
2. *Self-Inverse Property:* $A \oplus A = 0$
3. *Commutative Property:* $A \oplus B \oplus A = (A \oplus A) \oplus B = 0 \oplus B = B$

*Strategy:* By applying XOR across all elements, all paired integers cancel each other out, leaving only the unique value as the final result.

---

## 💻 Optimal Implementation (Java)

```java
/**
 * Solution for LeetCode 136: Single Number
 * Optimized for high-scale data processing with minimal resource overhead.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num; 
        }
        
        return result;
    }
}
[15:03, 13/03/2026] VISHAL: Systematic Trace (Dry Run)
Input Dataset: nums = [4, 1, 2, 1, 2]
[15:03, 13/03/2026] VISHAL: Iteration Element Operation Binary Computation Running Result
Initial - Seed Value 000 0
1 4 0 ^ 4 000 ^ 100 4
2 1 4 ^ 1 100 ^ 001 5
3 2 5 ^ 2 101 ^ 010 7
4 1 7 ^ 1 111 ^ 001 6
5 2 6 ^ 2 110 ^ 010 4 (Final)
