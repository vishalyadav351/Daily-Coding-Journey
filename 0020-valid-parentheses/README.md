# 20. Valid Parentheses 🧩

## 📝 Problem Description
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

---

## 💡 Logic & Approach
To solve this problem efficiently, I used the *Stack* data structure. 

### Why Stack?
Parentheses follow a *Nested Structure. The bracket that is opened **last* must be closed *first. This is the exact definition of **LIFO (Last In First Out)*, which is the core principle of a Stack.

### Step-by-Step Algorithm:
1. *Initialize* an empty Character Stack.
2. *Traverse* each character c in the string:
   - If c is an *opening bracket* ((, {, [), *push* it onto the stack.
   - If c is a *closing bracket*:
     - Check if the stack is empty. If yes, return false (Unbalanced).
     - *Pop* the top element from the stack and compare it with c.
     - If they are not a matching pair, return false.
3. *Final Check: After the loop, if the stack is **empty*, return true. Otherwise, return false.

---

## 🚀 Dry Run (Example: s = "([)]")

| Step | Char | Action | Stack Status | Comparison | Result |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | ( | Push | [ *(* ] | - | - |
| 2 | [ | Push | [ (, *[* ] | - | - |
| 3 | ) | Pop | [ *(* ] | Is ) match with [? | *❌ False* |

---

## 📊 Complexity Analysis

- *Time Complexity:* $O(n)$  
  We iterate through the string exactly once, where $n$ is the length of the string.
  
- *Space Complexity:* $O(n)$  
  In the worst case (e.g., s = "((((("), we push all characters into the stack.

---

## 🛠️ Tech Stack Used
- *Language:* Java
- *Data Structure:* Stack
-
