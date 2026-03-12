# 🚀 LeetCode #21: Merge Two Sorted Lists

### 📌 Problem Description
You are given the heads of two sorted linked lists, list1 and list2. Merge them into a single *sorted* linked list by splicing together the nodes of the first two lists.

*Example 1 Visual Reference:*
<img src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />



---

### 🏗️ Engineering Strategy
To solve this at a high technical standard, I implemented an *Iterative Approach* using a *Sentinel (Dummy) Node*.

* *Sentinel Node:* A dummy node is used to simplify the head management and avoid extra null checks for the result list.
* *In-Place Pointer Manipulation:* Instead of creating new memory objects, I rearranged the existing .next pointers, ensuring optimal space usage ($O(1)$ Space).
* *Optimization:* Once one list is exhausted, the remaining part of the other list is attached in $O(1)$ time since it is already sorted.

---

### 📊 Complexity Analysis
* *Time Complexity:* $O(n + m)$ — Where $n$ and $m$ are the lengths of both lists. Each node is visited exactly once.
* *Space Complexity:* $O(1)$ — No extra space used except for a few pointers.

---

### 🔍 Tracing the Algorithm (Dry Run)
*Input:* list1 = [1, 2, 4], list2 = [1, 3, 4]

| Step | list1.val | list2.val | Action Taken | Merged List State |
| :--- | :--- | :--- | :--- | :--- |
| *Start* | 1 | 1 | 1 <= 1 (Pick list1) | dummy -> 1 |
| *2* | 2 | 1 | 1 < 2 (Pick list2) | dummy -> 1 -> 1 |
| *3* | 2 | 3 | 2 <= 3 (Pick list1) | dummy -> 1 -> 1 -> 2 |
| *4* | 4 | 3 | 3 < 4 (Pick list2) | dummy -> 1 -> 1 -> 2 -> 3 |
| *End* | 4 | null | Attach remaining list1 | dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 |


