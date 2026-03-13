[14:57, 13/03/2026] VISHAL: 🚀 Single Number - Optimal Bit Manipulation Solution
📌 Problem Overview
Given a non-empty array of integers nums, every element appears twice except for one. The goal is to find that single element.
🎯 Objective
Time Complexity: O(n)
Space Complexity: O(1) (Constant Extra Space)
🧠 Engineering Approach: The XOR Strategy
To meet the strict O(1) space requirement, we avoid using HashMaps or Sorting. Instead, we leverage the Bitwise XOR (\oplus) operator properties:
Identity: A \oplus 0 = A
Self-Inverse: A \oplus A = 0
Commutative & Associative: The order of operations does not change the result.
By XORing all elements in the array, all pairs cancel each other out (A \oplus A = 0), leaving behind only the unique element.
🛠️ Implementation (Java)
/**
 * Logic: Bit Manipulation (XOR)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XORing each element
        }
        return result;
    }
}
🔍 Dry Run Analysis
Input: nums = [4, 1, 2, 1, 2]
Step Element Calculation Current Result (Binary)
Initial - 0 000
1 4 0 ^ 4 100 (4)
2 1 4 ^ 1 101 (5)
3 2 5 ^ 2 111 (7)
4 1 7 ^ 1 110 (6)
5 2 6 ^ 2 100 (4)
📈 Performance Comparison
Approach Time Complexity Space Complexity Notes
Brute Force O(n^2) O(1) Too slow for large datasets.
Sorting O(n \log n) O(1) Modifies the input array.
Hash Set O(n) O(n) High memory overhead.
XOR (Optimal) O(n) O(1) Most efficient solution.
