# Add Two Numbers

### 🔗 Problem Link
https://leetcode.com/problems/add-two-numbers/

---

## 🧠 Problem Summary
Given two non-empty linked lists representing two non-negative integers.
Digits are stored in reverse order. Add the two numbers and return the sum as a linked list.

---

## 💡 Approach

- Create a dummy node to store the result.
- Traverse both linked lists at the same time.
- Add corresponding digits along with carry.
- Store (sum % 10) in a new node.
- Update carry = sum / 10.
- Continue until both lists and carry become null.

---

## 🪜 Dry Run

l1 = 2 → 4 → 3  
l2 = 5 → 6 → 4  

Step 1:
2 + 5 = 7 → Node(7)

Step 2:
4 + 6 = 10  
Write 0, Carry = 1

Step 3:
3 + 4 + 1 = 8 → Node(8)

Final Output:
7 → 0 → 8

---

## ⏱ Time Complexity
O(max(n, m))

## 💾 Space Complexity
O(max(n, m))